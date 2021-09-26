package objectOrientedProgramming;

import java.util.Objects;

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
        return String.format("DataJava{payload=%s}; hashCode: %d", payload, hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataJava dataJava = (DataJava) o;
        return Objects.equals(payload, dataJava.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload);
    }
}
