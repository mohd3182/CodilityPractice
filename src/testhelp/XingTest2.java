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
public class XingTest2 {

    public static void main(String arg0[]) {
        int[] A = {40,40,100,80,20};
        int[] B = {3,3,2,2,3};
        int result = new XingTest2().solution(A, B, 3, 5, 200);
        System.out.println("result is:" + result);
        
       /* int[] A = {60, 80, 40};
        int[] B = {2, 3, 5};
        int result = new XingTest2().solution(A, B, 5,2,200);
        System.out.println("result is:" + result);*/
        

    }

    public int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        //M Floors
        //X count
        //Y weight
        int position = 0;
        int movesCount = 0;
        for (int pax : A) {

        }
        int paxCount = 0;
        int weightCount=0;
        int lastPosition=0;
        while (position <= A.length) {
            
            if(position<A.length){
            weightCount=weightCount+A[position];
            paxCount++;
            
            
            }
            
            if (paxCount >= X || weightCount>=Y || position>=A.length) {
                int[] tempB = Arrays.copyOfRange(B, lastPosition, position);
                Arrays.sort(tempB);
                int lastMove = 0;
                for (int i : tempB) {
                    if (i != lastMove) {
                        movesCount++;
                    }
                    lastMove = i;
                }
                movesCount++;
                paxCount = 1;
                if(position<A.length){
                weightCount=A[position];
                lastPosition=position;
                }
            }
            
            
            position++;
        }

        return movesCount;
    }

}
