package edu.zut.com.imooc.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateText {

     @Test
     public void testadd() {
	     assertEquals(6,new Calculate().add(3, 3));
    }
     @Test
     public void testsubtract() {
    	 assertEquals(2,new Calculate().subtract(6, 4));
     }
     @Test
     public void testmultiply() {
    	 assertEquals(9,new Calculate().multiply(3, 3));
     }
     @Test
     public void testdivide() {
    	 assertEquals(2,new Calculate().divide(8, 4));
     }
     /*
      * 1.测试方法必须要用@修饰
      * 2.测试方法必须用 public void不能加任何参数
      * 3.新建一个源代码目录来存放我们的测试代码
      * 4.测试类的包应该和被测试类的包保持一致
      * 5.测试单元中的每个方法必须可以独立测试，测试方法不能有任何依赖
      * 6.测试类使用test作为类名的后缀（不是必须）
      * 7.测试方法使用test作为方法名的前缀（不是必须）
      */
     
     
}
