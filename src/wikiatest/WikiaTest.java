/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wikiatest;

import com.test.Attendee;
import com.test.MeetingSlot;
import com.test.Time;
import com.test.TimeSlot;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Arrays;
import java.util.stream.LongStream;
import java.util.function.LongPredicate;

/**
 *
 * @author Mohamed Laptop
 */
public class WikiaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        System.out.println("Date is :" + calendar.getTime());

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.HOUR_OF_DAY, 12);
        calendar2.set(Calendar.MINUTE, 0);
        System.out.println("Date 2 is :" + calendar2.getTime());

        TimeSlot[] arr = {new TimeSlot(new GregorianCalendar(2015, 10, 28, 9, 24, 56)), new TimeSlot(new GregorianCalendar(2015, 10, 27, 11, 28, 56))};
        Attendee attendee1 = new Attendee(1234, "Elbert John", 9, 17, arr);

        TimeSlot[] arr2 = {new TimeSlot(new GregorianCalendar(2015, 10, 28, 9, 24, 56)), new TimeSlot(new GregorianCalendar(2015, 10, 27, 11, 28, 56))};
        Attendee attendee2 = new Attendee(2654, "Danny Scott", 8, 15, arr2);

        TimeSlot[] arr3 = {new TimeSlot(new GregorianCalendar(2015, 10, 28, 11, 24, 56))};
        Attendee attendee3 = new Attendee(3654, "Diana Adam", 9, 17, arr3);

        List attendees = new ArrayList();
        attendees.add(attendee1);
        attendees.add(attendee2);
        attendees.add(attendee3);
        List allTimes = new WikiaTest().suggestMeetingSlots(attendees, 5, Time.Hour, calendar, calendar2);
    }

    /*
     * 
     * 
     * 
     * 
     */
    public List<MeetingSlot> suggestMeetingSlots(List<Attendee> attendees, int slotsNumber, Time meetingLength, Calendar fromTime, Calendar toTime) {

        fromTime.setTimeInMillis(fromTime.getTimeInMillis() - (fromTime.getTimeInMillis() % (30 * 1000 * 60)));
        System.out.println("Date is :" + fromTime.getTime());

        long diffrent = toTime.getTimeInMillis() % (30 * 1000 * 60);
        if (diffrent > 0) {
            toTime.setTimeInMillis(toTime.getTimeInMillis() + ((30 * 1000 * 60) - diffrent));
            System.out.println("Date to is :" + toTime.getTime());
        }
        List allTimes = new ArrayList();

        int slotAccumulatedTotal = 0;

        List tempTimes = new ArrayList();
        List resultTimes = new ArrayList();
        for (long i = fromTime.getTimeInMillis(); i < toTime.getTimeInMillis();) {
            int maxAttendeesCount = attendees.size();
            int attendeesCount = attendees.size();

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(i);

            System.out.println("Date Calendar is :" + calendar.getTime());
            for (Attendee attendee : attendees) {

                Calendar endSlot = Calendar.getInstance();
                endSlot.setTimeInMillis(calendar.getTimeInMillis() + (30 * 1000 * 60));
                if (Arrays.stream(attendee.getOccupiedSlots()).anyMatch(l -> (l >= calendar.getTimeInMillis() && l <= calendar.getTimeInMillis() + (30 * 1000 * 60))
                        || calendar.get(Calendar.HOUR_OF_DAY) < attendee.getShiftStartHour() || endSlot.get(Calendar.HOUR_OF_DAY) > attendee.getShiftEndHour())) {
                    attendeesCount--;
                }

            }
            MeetingSlot meetingSlot = new MeetingSlot(calendar, attendeesCount, slotAccumulatedTotal, "");
            if (maxAttendeesCount == attendeesCount) {
                slotAccumulatedTotal++;

                tempTimes.add(meetingSlot);
                if (slotAccumulatedTotal >= meetingLength.ordinal()) {
                    resultTimes.addAll(tempTimes);
                    tempTimes.clear();
                }

            } else {
                slotAccumulatedTotal = 0;
            }

            allTimes.add(meetingSlot);
            i = i + (30 * 1000 * 60);
        }

        return resultTimes;
    }
}
