/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testhelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mohamed Laptop
 */
public class TestHelp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int weeks = TestHelp.solution(2012, "April", "July", "Sunday");
      //  String result = TestHelp.monthLastDay("Thursday", 30);
System.out.println("Weeks:"+weeks);
      // int noofWeeks = TestHelp.weeksBetween("Wednesday", 62);
    }

    public static int solution(int Y, String A, String B, String W) {


        Map yearMapLastDay = new HashMap();
        int daysBetween = 0;
        boolean flagStart = false;

        Map<String, Integer> weekDays = new HashMap<String, Integer>();
        weekDays.put("Monday", 1);
        weekDays.put("Tuesday", 2);
        weekDays.put("Wednesday", 3);
        weekDays.put("Thursday", 4);
        weekDays.put("Friday", 5);
        weekDays.put("Saturday", 6);
        weekDays.put("Sunday", 7);


        String weekDaysArray[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String Months[] = {"January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};
        for (String month : Months) {

            if (month.equalsIgnoreCase(A)) {
                flagStart = true;
            }



            int monthDays = 30;

            if (month.equalsIgnoreCase("January") || month.equalsIgnoreCase("March") || month.equalsIgnoreCase("May") || month.equalsIgnoreCase("July")
                    || month.equalsIgnoreCase("December") || month.equalsIgnoreCase("October")) {
                monthDays = 31;
            }
            if (month.equalsIgnoreCase("February")) {

                if (Y % 4 == 0) {
                    monthDays = 29;
                } else {
                    monthDays = 28;
                }
            }

            String monthLastDay = TestHelp.monthLastDay(W, monthDays);
            yearMapLastDay.put(month, monthLastDay);
            int weekDay = weekDays.get(monthLastDay);
            if (weekDay == 7) {
                weekDay = 0;
            }
            W = weekDaysArray[weekDay];
            if (flagStart) {
                daysBetween = daysBetween + monthDays;
            }
            if (month.equalsIgnoreCase(B)) {
                flagStart = false;
            }

        }

        return TestHelp.weeksBetween(W, daysBetween);
    }

    public static int monthCount(String month) {
        String Months[] = {"January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};
        int count = 0;
        while (count < Months.length) {
            if (Months[count].equalsIgnoreCase(month)) {
                return count;
            }
            count++;
        }
        return -1;

    }

    public static String monthLastDay(String firstDayOfMonth, int noOfDays) {
        String currentDay = "";
        String weekDays[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        boolean stopflag = true;
        int count = 0;
        boolean incrementFlag = false;
        // int weekdayscount=0;
        // boolean weekdays=false;
        // int weeks=0;
        while (noOfDays > 0) {

            if (!incrementFlag && weekDays[count].equalsIgnoreCase(firstDayOfMonth)) {
                incrementFlag = true;
            }
            currentDay = weekDays[count];
            if (incrementFlag) {
                /* if(weekDays[count].equalsIgnoreCase("Monday")){weekdays=true;}
                 if(weekdays==true){weekdayscount++;
                 if(weekdayscount>6){weekdayscount=0;weeks++;}
                 }*/


                noOfDays--;
            }
            if (count == 6) {
                count = 0;
            } else {
                count++;
            }

        }


        return currentDay;
    }

    public static int weeksBetween(String firstDayOfMonth, int noOfDays) {
        String weekDays[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int count = 0;
        int weekdayscount = 0;
        int weeks = 0;
        boolean weekdays = false;
        boolean incrementFlag = false;
        while (noOfDays > 0) {

            if (!incrementFlag && weekDays[count].equalsIgnoreCase(firstDayOfMonth)) {
                incrementFlag = true;
            }

            if (incrementFlag) {
                if (weekDays[count].equalsIgnoreCase("Monday")) {
                    weekdays = true;
                }
                if (weekdays == true) {
                    weekdayscount++;
                    if (weekdayscount > 6) {
                        weekdayscount = 0;
                        weeks++;
                    }
                }


                noOfDays--;
            }
            if (count == 6) {
                count = 0;
            } else {
                count++;
            }

        }

        return weeks;
    }
}
