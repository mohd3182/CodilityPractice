/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testhelp;

/**
 *
 * @author Mohamed Laptop
 */
public class CodilityFrogJump {

    public static void main(String arg[]) {
        
        /*
         * 
         * For example, for the input (3, 999111321, 7) 
         * the solution returned a wrong answer (got 142730192 expected 142730189)
         */
        int result=new CodilityFrogJump().solution(3, 999111321, 7);
        System.out.println("result is:"+result);
    }

    public int solution(int X, int Y, int D) {
        double desiredDistance=Y-X;
        int stepsNeeded;
       
if(desiredDistance%D==0){
        stepsNeeded=(int) (desiredDistance/D);
        }else {
        stepsNeeded=(int) ((desiredDistance/D)+1);
        }
        return stepsNeeded;
    }
}
