package objectOrientedProgramming;

/**
 * Java old style way (POJO) to implement a data class in kotlin.
 *
 * Java's new version will deliver similar features.
 *
 * Or you can use 3rd party library like lombok (which imho is not good = dependency).
 * In kotlin > 1.5.20 there is a support to interact with lombok generated code.
 */
public class DataJava {
    private String payload;

    public DataJava(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    /**
     * implement explicitly in java.
     * in kotlin we have this for free.
     */
    @Override
    public String toString() {
        return "DataJava{" +
                "payload='" + payload + '\'' +
                '}';
    }
}
