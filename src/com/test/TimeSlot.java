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
public class TimeSlot  {
    
    
    private long slotTime;

    public TimeSlot(Calendar cal) {
        
        this.slotTime=cal.getTimeInMillis() - (cal.getTimeInMillis() % (30 * 1000 * 60));
    }

    
    
    public long getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(long slotTime) {
        this.slotTime = slotTime;
    }
    
    
}
