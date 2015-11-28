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
    private int shiftStartHour;
    private int shiftEndHour;
    private long[] occupiedSlots;

    public Attendee() {
    }

    public Attendee(int attendeeId, String attendeeName, int shiftStartHour, int shiftEndHour, TimeSlot[] occupiedSlots) {
        this.attendeeId = attendeeId;
        this.attendeeName = attendeeName;
        this.shiftStartHour = shiftStartHour;
        this.shiftEndHour = shiftEndHour;


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

    public int getShiftStartHour() {
        return shiftStartHour;
    }

    public void setShiftStartHour(int shiftStartHour) {
        this.shiftStartHour = shiftStartHour;
    }

    public int getShiftEndHour() {
        return shiftEndHour;
    }

    public void setShiftEndHour(int shiftEndHour) {
        this.shiftEndHour = shiftEndHour;
    }

    public long[] getOccupiedSlots() {
        return occupiedSlots;
    }

    public void setOccupiedSlots(long[] occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }
}
