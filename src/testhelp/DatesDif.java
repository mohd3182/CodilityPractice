/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testhelp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mohamed Laptop
 */
public class DatesDif {

    public static void main(String[] args) {
        
        int weeks=new DatesDif().solution(2015,"January","March",null);
        System.out.println("result is:"+weeks);
        
    }

    public int solution(int Y, String A, String B, String W) {
        Map<String, Integer> monthsMap = new HashMap();
        monthsMap.put("January", 0);
        monthsMap.put("February", 1);
        monthsMap.put("March", 2);
        monthsMap.put("April", 3);
        monthsMap.put("May", 4);
        monthsMap.put("June", 5);
        monthsMap.put("July", 6);
        monthsMap.put("August", 7);
        monthsMap.put("September", 8);
        monthsMap.put("October", 9);
        monthsMap.put("November", 10);
        monthsMap.put("December", 11);

        int Amonth = -1;
        int Bmonth = -1;

        try{
        Amonth = monthsMap.get(A);
        Bmonth = monthsMap.get(B);
        }catch(Exception e){
        e.printStackTrace();
        }
        if (Amonth == -1 || Bmonth == -1) {
            return -1;
        }


        Calendar calFromMonth = Calendar.getInstance();
        Calendar calToMonth = Calendar.getInstance();

        calFromMonth.set(Y, Amonth, 1);
        calToMonth.set(Y, Bmonth, 1);
        int lastDayMonth = calToMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
        calToMonth.set(Calendar.DAY_OF_MONTH, lastDayMonth);
        if (!calFromMonth.before(calToMonth)) {

            return -1;
        }
        //sunday 0-->1   1-->0   2-->6  3-->5  4-->4   5-->3   6-->2
        int firstDayWeek = calFromMonth.get(Calendar.DAY_OF_WEEK);
        int dayDiff = 0;


        switch (firstDayWeek) {
            case 0:
                dayDiff = 1;
                break;
            case 1:
                dayDiff = 0;
                break;
            case 2:
                dayDiff = 6;
                break;
            case 3:
                dayDiff = 5;
                break;
            case 4:
                dayDiff = 4;
                break;
            case 5:
                dayDiff = 3;
                break;
            case 6:
                dayDiff = 2;
                break;
        }


        calFromMonth.add(Calendar.DAY_OF_MONTH, dayDiff);


        long timeMilis = calToMonth.getTimeInMillis() - calFromMonth.getTimeInMillis();

         int days=(int) (timeMilis/(1000*60*60*24));

         int week=days/7;
        return week;
    }
}
