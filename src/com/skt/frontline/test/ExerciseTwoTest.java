package com.skt.frontline.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ExerciseTwoTest {

	ExerciseTwo exTwo;
	List<String> myList;
	
	public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("ExcerciseTwoTest");
    }
	
	@Before
	public void setup() {
		 StringWriter output = new StringWriter();
	     PrintWriter outWriter = new PrintWriter(output);
		exTwo = new ExerciseTwo(outWriter);
		myList = exTwo.createSampleList();
	}
	@Test
	public void test_01() {		
		assertNotNull(myList);
	}

	@Test
	public void test_02() {
		exTwo.sort(myList);
		assertEquals("List is NOT Sorted", myList.get(0),"1.2.3");
	}

	//Check first element of TreeSet
	@Test
	public void test_03() {
		List<String> resultList = exTwo.processList(myList);
		assertNotNull(resultList);
		assertEquals("Incorrect Result", resultList.get(0).charAt(0),'1');
	}
	
	//Check second element of TreeSet
	@Test
	public void test_04() {
		List<String> resultList = exTwo.processList(myList);
		assertNotNull(resultList);
		assertEquals("Incorrect Result", resultList.get(1),"--2\n---3\n");
	}
}