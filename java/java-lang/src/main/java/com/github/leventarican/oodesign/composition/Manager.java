package com.github.leventarican.oodesign.composition;

/**
 * this object holds a reference to a secondary object; it forwards all
 * operations to the secondary object;
 *
 * @author levent
 */
public class Manager implements Employee {

    private Employee staff;

    // manager doesnt work; delegate the work.
    @Override
    public void work() {
        staff.work();
    }

    public Manager(Employee staff) {
        this.staff = staff;
    }

    public void setStaff(Employee staff) {
        this.staff = staff;
    }

}
