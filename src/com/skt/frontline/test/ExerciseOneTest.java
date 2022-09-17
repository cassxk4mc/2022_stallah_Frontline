package com.skt.frontline.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExerciseOneTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	ExerciseOne exOne;
	
	public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("ExerciseOneTest");
    }
	
	@Before
	public void setup() {
		System.setOut(new PrintStream(outputStreamCaptor));
		exOne = new ExerciseOne();
		int arr[] = {5, 6, 13, 5, 17, 18, 19, 21, 2};
		exOne.printLongestIncSubArr(arr);
	}
	
	@After
	//restoring it to its original state when our test terminates
	public void tearDown() {
	    System.setOut(standardOut);
	}
	
	@Test
	//input Array {5, 6, 13, 5, 17, 18, 19, 21, 2}
	//Output 5 17 18 19 21
	public void test_01() {		
		Assert.assertEquals("5 17 18 19 21", outputStreamCaptor.toString().trim());
	}
}