package training;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/*
 * ÕÅ·«
 */
@Listeners(testListener.class)
public class TestDemo {
	@Test
	public void test1(){
		Assert.assertEquals(1,1);
	}
	@Test
	public void test2(){
		Assert.assertEquals(9,1);
	}
	@Test
	public void test3(){
		Assert.assertEquals(6,5);
	}
	@Test
	public void test4(){
		Assert.assertEquals(7,7);
	}
	@Test
	public void test5(){
		Assert.assertEquals(3,3);
	}
	
}
