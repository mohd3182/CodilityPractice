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
public class MissingSeq {
    
    
    public static void main(String arg[]){
    
        int[] A={1,};
        
       int result =new MissingSeq().solution(A);
    }
    
    
    
      public int solution(int[] A) {
          try{
        // write your code in Java SE 8
          String arrayValue="";
          Arrays.sort(A);
          int n=A.length+1;
  
          
          for (int w=1;w<=n;w++){

              if(w>A.length||!(A[w-1]==w)){
              return w;
              }
              
          }
          }catch(Exception e){return -1;}
          return 0;
       
    }
    
}
