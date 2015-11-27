/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

/**
 *
 * @author Mohamed Laptop
 */
public enum Time {
        HalfHour(1), Hour(2), HourAndHalf(3), TwoHours(4),TwoHoursAndHalf(5),ThreeHours(6);
        private int value;

        private Time(int value) {
                this.value = value;
        }


}
