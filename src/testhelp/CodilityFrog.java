/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testhelp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mohamed Laptop
 */
public class CodilityFrog {

    public static void main(String arg[]) {
        
        int[] A={1,3,1,4,2,3,5,4};
        int result=new CodilityFrog().solution(5, A);
        System.out.println("result is:"+result);
    }

    public int solution(int X, int[] A) {

        int result = -1;
        //Step , Second
        Map timeMap = new HashMap();
        int second = 0;
        int resultSecond=0;
        for (int i : A) {

            if (timeMap.containsKey(i)) {
                if (Integer.parseInt(timeMap.get(i).toString()) > second) {
                    timeMap.put( i, second);
                    if(resultSecond<second){resultSecond=second;}
                }
            } else {
                timeMap.put( i, second);
                if(resultSecond<second){resultSecond=second;}
            }

            second++;
        }

        
        if(timeMap.size()==X){return resultSecond;}else{return -1;}
        

        
    }
}
