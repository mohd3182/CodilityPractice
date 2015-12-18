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
public class MissingNumber {
    
    public static void main(String arg0[]){
        int[] A={2};
       int result =new MissingNumber().solution(A);
       System.out.println("result is:"+result);
       
    
    }
    
        public int solution(int[] A) {
        // write your code in Java SE 8
            Arrays.sort(A);
            int arraySumEstimated = (A.length * (1 + A.length)) / 2;
            int sumArray=Arrays.stream(A).sum();
            int countcheck=0;
            for(int y:A){
            
            /*if(y-countcheck>1){
            return countcheck+1;
            }*/
                
               if(y==countcheck||y<1){
               
               return (arraySumEstimated-sumArray)+y;
               } 
                
           countcheck=y;
            }
            
            
            return -1;
    }
}
