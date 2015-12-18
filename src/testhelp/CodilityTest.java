/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testhelp;

import java.util.Arrays;

/**
 *
 * @author Mohamed Laptop
 */
public class CodilityTest {

    public static void main(String[] arg0) {

        int[] A = {3,1,2};
        int result = new CodilityTest().solution2(A);
        System.out.println("result is:" + result);
    }

    public int solution2(int[] A) {


        int arraySumActual = 0;
        int arraySumEstimated = (A.length * (1 + A.length)) / 2;
        Arrays.sort(A);
        int currentVal = 0;
        for (int i : A) {
            if (i <= currentVal) {
                return 0;
            }
            arraySumActual += i;
            currentVal=i;
        }
        if (arraySumEstimated - arraySumActual == 0) {
            return 1;
        }
        return 0;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        String val = "";
        int maxValue = 0;

        for (int i = 1; i <= A.length; i++) {
            val = val + "#" + i + "#";
            maxValue = i;
        }
        Arrays.sort(A);
        for (int y : A) {
            val = val.replace("#" + y + "#", "");
            if (maxValue < y) {
                return 0;
            }
        }
        if (val.length() == 0) {
            return 1;
        }

        return 0;
    }
}
