/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhelp;

import java.util.Arrays;

/**
 *
 * @author Mohamed Laptop
 */
public class XingTest {

    public static void main(String arg0[]) {

        String result = new XingTest().solution("0 - 22 1985--324");
        System.out.println("result is:" + result);
        
        String result2 = new XingTest().solution("555372654");
        System.out.println("result is:" + result2);

    }

    public String solution(String S) {
        String result = "";
        if (S.length() < 2) {
            return "";
        }

        S = S.replaceAll(" ", "");
        S = S.replaceAll("-", "");
        int totalCount=S.length();
        char[] chrAray = S.toCharArray();

        int charCount = 1;
        for (char i : chrAray) {

            result = result + i;
            
            if ((totalCount%3==0 && charCount % 3 == 0 && totalCount-charCount>2)
                    ||
                    (totalCount%2==0&&((charCount % 3 == 0 && totalCount-charCount>3) 
                    || totalCount-charCount==2))) {
                result = result + "-";
            }
            charCount++;

        }

        return result;
    }

}
