package com;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/*
 * Àîè¯
 */
@Listeners({com.JavaMailListener.class})
public class Listener {
	@Test
	public void send1() throws Exception{
		Assert.assertEquals(1, 1);
	}
	
	@Test
	public void send2() throws Exception{
		Assert.assertEquals(9, 1);
	}
	
	@Test
	public void send3() throws Exception{
		Assert.assertEquals(2, 1);
	}
	
	@Test
	public void send4() throws Exception{
		Assert.assertEquals(3, 1);
	}

}
