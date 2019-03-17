package edu.zut.com.imooc.junit;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class AnotationTest {

	/*
	 * @Test:将一个普通方法修饰成为一个测试方法
	 *            @Test(expected=xxx.class)捕获异常
	 *            @Test(timeout=毫秒)
	 * @BofterClass：它会在所有的方法运行前执行，static修饰
	 * @AfterClass：它会在所有的方法运行前被执行，static修饰
	 * @Befter：它会在每一个测试方法运行前被执行一次，void修饰
	 * @After：它会在每一个测试方法运行后被执行一次，void修饰
	 * @Ignore:所修饰的方法会在执行时忽略
	 * @Runwith:可以更改测试运行器
	 */
	@Test(expected=ArithmeticException.class)
public void testdivide() {
	 assertEquals(2,new Calculate().divide(8, 0));
}
	@Ignore
	@Test(timeout=2000)
	public void testWhile() {
		while(true) {
			System.out.println("我在熬夜！");
		}
	}
		
	@Test(timeout=3000)
	public void testReadfile(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}



