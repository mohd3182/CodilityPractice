/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.util.Calendar;

/**
 *
 * @author Mohamed Laptop
 */
public class MeetingSlot {
    
    private Calendar slotStart;
    private int attendeesCount;
    private int accumultedCount;
    private String attendeesNames;

    public MeetingSlot() {
    }

    public MeetingSlot(Calendar slotStart, int attendeesCount,int accumultedCount ,String attendeesNames) {
        this.slotStart = slotStart;
        this.attendeesCount = attendeesCount;
        this.accumultedCount = accumultedCount;
        this.attendeesNames = attendeesNames;
    }

    public int getAccumultedCount() {
        return accumultedCount;
    }

    public void setAccumultedCount(int accumultedCount) {
        this.accumultedCount = accumultedCount;
    }

    
    
    
    public Calendar getSlotStart() {
        return slotStart;
    }

    public void setSlotStart(Calendar slotStart) {
        this.slotStart = slotStart;
    }

    public int getAttendeesCount() {
        return attendeesCount;
    }

    public void setAttendeesCount(int attendeesCount) {
        this.attendeesCount = attendeesCount;
    }

    public String getAttendeesNames() {
        return attendeesNames;
    }

    public void setAttendeesNames(String attendeesNames) {
        this.attendeesNames = attendeesNames;
    }
    
    
    
}
