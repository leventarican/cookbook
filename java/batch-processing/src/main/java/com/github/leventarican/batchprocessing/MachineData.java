package com.github.leventarican.batchprocessing;

/**
 * @author Levent
 */
public class MachineData {

    private String header;
    private String payload;

    public MachineData(String header, String payload) {
        this.header = header;
        this.payload = payload;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "machine data: " + header + "; " + payload;
    }
}
