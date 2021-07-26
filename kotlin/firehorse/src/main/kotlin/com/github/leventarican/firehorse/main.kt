import software.amazon.awssdk.core.SdkBytes
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.firehose.FirehoseClient
import software.amazon.awssdk.services.firehose.model.*
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.*
import java.text.SimpleDateFormat
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.random.Random


fun tutorialSetup(s3Client: S3Client, bucketName: String, region: Region) {
    try {
        s3Client.createBucket(
            CreateBucketRequest
                .builder()
                .bucket(bucketName)
                .createBucketConfiguration(
                    CreateBucketConfiguration.builder()
                        .locationConstraint(region.id())
                        .build()
                )
                .build()
        )
        println("Creating bucket: $bucketName")
        s3Client.waiter().waitUntilBucketExists(
            HeadBucketRequest.builder()
                .bucket(bucketName)
                .build()
        )
        println("$bucketName is ready.")
        System.out.printf("%n")
    } catch (e: S3Exception) {
        System.err.println(e.awsErrorDetails().errorMessage())
        System.exit(1)
    }
}

fun cleanUp(s3Client: S3Client, bucketName: String, keyName: String) {
    println("Cleaning up...")
    try {
        println("Deleting object: $keyName")
        val deleteObjectRequest = DeleteObjectRequest.builder().bucket(bucketName).key(keyName).build()
        s3Client.deleteObject(deleteObjectRequest)
        println("$keyName has been deleted.")
        println("Deleting bucket: $bucketName")
        val deleteBucketRequest = DeleteBucketRequest.builder().bucket(bucketName).build()
        s3Client.deleteBucket(deleteBucketRequest)
        println("$bucketName has been deleted.")
        System.out.printf("%n")
    } catch (e: S3Exception) {
        System.err.println(e.awsErrorDetails().errorMessage())
        System.exit(1)
    }
    println("Cleanup complete")
    System.out.printf("%n")
}

fun s3Example() {
    val region: Region = Region.US_WEST_2
    val s3 = S3Client.builder().region(region).build()
    val bucket = "bucket" + System.currentTimeMillis()
//    val bucket = "bucket1627156766439"
    val key = "key"

    tutorialSetup(s3, bucket, region)
    println("Uploading object...")
    s3.putObject(
        PutObjectRequest.builder().bucket(bucket).key(key)
            .build(),
        RequestBody.fromString("Testing with the {sdk-java}")
    )
    println("Upload complete")

    cleanUp(s3, bucket, key)
    println("Closing the connection to {S3}")
    s3.close()
    println("Connection closed")
    println("Exiting...")
}

fun createStream(firehoseClient: FirehoseClient, bucketARN: String?, roleARN: String?, streamName: String?) {
    try {
        val destinationConfiguration = ExtendedS3DestinationConfiguration.builder()
            .bucketARN(bucketARN)
            .roleARN(roleARN)
            .build()
        val deliveryStreamRequest = CreateDeliveryStreamRequest.builder()
            .deliveryStreamName(streamName)
            .extendedS3DestinationConfiguration(destinationConfiguration)
            .deliveryStreamType("DirectPut")
            .build()
        val streamResponse = firehoseClient.createDeliveryStream(deliveryStreamRequest)
        println("Delivery Stream ARN is " + streamResponse.deliveryStreamARN())
    } catch (e: FirehoseException) {
        println(e.localizedMessage)
        System.exit(1)
    }
}

fun delStream(firehoseClient: FirehoseClient, streamName: String) {
    try {
        val deleteDeliveryStreamRequest = DeleteDeliveryStreamRequest.builder()
            .deliveryStreamName(streamName)
            .build()
        firehoseClient.deleteDeliveryStream(deleteDeliveryStreamRequest)
        println("Delivery Stream $streamName is deleted")
    } catch (e: FirehoseException) {
        println(e.localizedMessage)
        System.exit(1)
    }
}

fun putSingleRecord(firehoseClient: FirehoseClient, textValue: String, streamName: String?) {
    try {
        val sdkBytes = SdkBytes.fromByteArray(textValue.toByteArray())
        val record = Record.builder()
            .data(sdkBytes)
            .build()
        val recordRequest = PutRecordRequest.builder()
            .deliveryStreamName(streamName)
            .record(record)
            .build()
        val recordResponse = firehoseClient.putRecord(recordRequest)
        println("The record ID is " + recordResponse.recordId())
    } catch (e: FirehoseException) {
        println(e.localizedMessage)
        System.exit(1)
    }
}

fun firehorseExample() {
    val region: Region = Region.US_WEST_2
    val firehoseClient: FirehoseClient = FirehoseClient.builder()
        .region(region)
        .build()

    val bucketARN = "arn:aws:s3:::TODO"
    val roleARN = "arn:aws:iam::TODO"
    val streamName = "delete"
//    createStream(firehoseClient, bucketARN, roleARN, streamName)
//    delStream(firehoseClient, streamName)

    // produce record
    val textValue = "kotlin aws sdk debug text ${System.currentTimeMillis()}"
    val id = Random.nextInt(0, 1000)
    val iso = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Date())
    val jsonValue =
        """{{"id":"$id","timestamp":"$iso","node":{"id":"001","fieldA":"","subNodes":[{"colour":"","quantity":10,"subNodes":[]}]},"orders":{"order":[{"status":"done"},{"status":"done"}],"timestamp":"2021-07-01T16:00:50","isDone":true},"debug":{"debugValue":"100.0"},"version":"v0.0.1","tags":[{"feature":"security","release":"2021.0"}]}}""".trimIndent()
    println(jsonValue)
    putSingleRecord(firehoseClient, jsonValue, streamName);

    firehoseClient.close()
}

fun main(args: Array<String>) {
    println("Hello World!")

//    s3Example()
    firehorseExample()
}