package com.atguigu.maven;	
	import org.junit.Test;
	import static junit.framework.Assert.*;
	public class HelloTest {
		@Test
		public void testHello(){
			Hello hello = new Hello();
			String results = hello.sayHello("哈哈");
			assertEquals("Hello 哈哈!",results);	
		}
	}
