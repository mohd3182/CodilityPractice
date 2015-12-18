/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testhelp;

/**
 *
 * @author Mohamed Laptop
 */
public class CodilityLesson1 {

    public static void main(String arg[]) {
        int[] A = {3, 1, 2, 4, 3};
        int result = new CodilityLesson1().solution(A);
        System.out.println("result is:" + result);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int p = A.length - 1;

        int minimalDif = 2147483647;
        long valuePostSum = 0;
        long valuePreSum = 0;
        //get sum of all array

        for (int currentVal : A) {
            valuePostSum = valuePostSum + currentVal;
        }


        for (int currentP = 1; currentP <= p; currentP++) {
            valuePreSum = valuePreSum + A[currentP - 1];
            valuePostSum = valuePostSum - A[currentP - 1];

            if (Math.abs(valuePreSum - valuePostSum) < minimalDif) {
                minimalDif = (int) Math.abs(valuePreSum - valuePostSum);
                if (minimalDif == 0) {
                    return 0;
                }
            }

        }

        return minimalDif;
    }
}
