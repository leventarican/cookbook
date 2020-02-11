package com.github.leventarican.batchprocessing;

/**
 * @author Levent
 */
public class MachineThing extends Thing<MachineData>{

    private MachineData data;
    
    @Override
    public void process() {
        MachineData data = new MachineData();
        data.setHeader("header");
        data.setPayload("payload");
        
        this.data = data;
    }

    @Override
    public String toString() {
        String str = "machine thing: " + data.getHeader() + "; " + data.getPayload();
        System.out.println(str);
        return str;
    }
}
