import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.*

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

fun main(args: Array<String>) {
    println("Hello World!")

    val region: Region = Region.US_WEST_2
    val s3 = S3Client.builder().region(region).build()
//    val bucket = "bucket" + System.currentTimeMillis()
    val bucket = "bucket1627156766439"
    val key = "key"

//    tutorialSetup(s3, bucket, region)
//    println("Uploading object...")
//    s3.putObject(
//        PutObjectRequest.builder().bucket(bucket).key(key)
//            .build(),
//        RequestBody.fromString("Testing with the {sdk-java}")
//    )
//    println("Upload complete")
//
//    cleanUp(s3, bucket, key)
//    println("Closing the connection to {S3}")
//    s3.close()
//    println("Connection closed")
//    println("Exiting...")
}