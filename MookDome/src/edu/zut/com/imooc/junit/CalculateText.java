package edu.zut.com.imooc.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateText {

     @Test
     public void add() {
	     assertEquals(6,new Calculate().add(3, 3));
    }
     @Test
     public void subtract() {
    	 assertEquals(2,new Calculate().subtract(6, 4));
     }
     @Test
     public void multiply() {
    	 assertEquals(9,new Calculate().multiply(3, 3));
     }
     @Test
     public void divide() {
    	 assertEquals(2,new Calculate().divide(8, 4));
     }
}
