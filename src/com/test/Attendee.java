/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Mohamed Laptop
 */
public class Attendee {

    private int attendeeId;
    private String attendeeName;
    private int shiftStartSlot;
    private int shiftEndSlot;
    private long[] occupiedSlots;

    public Attendee() {
    }

    public Attendee(int attendeeId, String attendeeName, int shiftStartSlot, int shiftEndSlot, TimeSlot[] occupiedSlots) {
        this.attendeeId = attendeeId;
        this.attendeeName = attendeeName;
        this.shiftStartSlot = shiftStartSlot;
        this.shiftEndSlot = shiftEndSlot;


        long[] occSolt = new long[occupiedSlots.length];
        int i = 0;
        for (TimeSlot timeSlot : occupiedSlots) {
            occSolt[i] = timeSlot.getSlotTime();

            i++;
        }

        this.occupiedSlots = occSolt;
    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public int getShiftStartSlot() {
        return shiftStartSlot;
    }

    public void setShiftStartSlot(int shiftStartSlot) {
        this.shiftStartSlot = shiftStartSlot;
    }

    public int getShiftEndSlot() {
        return shiftEndSlot;
    }

    public void setShiftEndSlot(int shiftEndSlot) {
        this.shiftEndSlot = shiftEndSlot;
    }

    public long[] getOccupiedSlots() {
        return occupiedSlots;
    }

    public void setOccupiedSlots(long[] occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }
}
