package com.skt.frontline.test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciseTwo {

	PrintWriter output;
	List<String> myList;
	
	public ExerciseTwo(PrintWriter output) {
		this.output = output;
	}

	public static void main(String[] args) {
		 StringWriter output = new StringWriter();
	     PrintWriter outWriter = new PrintWriter(output);
	     //Create Sample List
		ExerciseTwo exTwo = new ExerciseTwo(outWriter);
		List<String> myList = exTwo.createSampleList();
		//Sort the list
		myList = exTwo.sort(myList);
		exTwo.processList(myList);
	}

	protected List<String> createSampleList(){
		//creating sample Collection
		myList = new ArrayList<String>();
		
		String str1 = "1.5.6";
		String str3 = "1.2.5";
		String str4 = "1.2.4";
		String str5 = "2.5.6";
		String str2 = "1.2.3";
		String str6 = "1.5.7";
		String str7 = "2.5.3";
		/**
		String str1 = "1.5.6.4";
		String str3 = "1.2.5.3";
		String str4 = "5.1.2.4";
		String str5 = "3.2.5.6";
		String str2 = "4.1.2.3";
		String str6 = "2.1.5.7";
		String str7 = "4.2.5.3";
		**/
		myList.add(str1);
		myList.add(str2);
		myList.add(str3);
		myList.add(str4);
		myList.add(str5);
		myList.add(str6);
		myList.add(str7);
		
		return myList;
	}
	
	List<String> sort(List<String> myList){
		//Sort the list
		Collections.sort(myList);
		return myList;
	}
	
	void printList(List<String> myList) {
		//Just for reference
		myList.forEach(a ->	System.out.println(a));		
	}

	List<String> processList(List<String> myList) {
		List<String> resultList = new ArrayList<>();
		List<String> tempList = new ArrayList<>();
		StringBuilder strBldr = new StringBuilder();
		
		//Outer loop, to process each element from the list
		for(byte b=0; b < myList.size(); b++) {
			String currEle = myList.get(b);
			String prevEle = "";
			//Prevent Error when accessing prev element Before First element
			if(b != 0) {
				prevEle = myList.get(b-1);
				if(currEle.charAt(0) != prevEle.charAt(0)) {
					tempList.removeAll(tempList);
				}
			}
			//for each row eg: "1.2.3", loop thru element in list, check for each character eg: '1' 
			for (byte c = 0; c < currEle.length(); c++) {
				String currStr = String.valueOf(currEle.charAt(c));
				//if character exists, continue with next iteration
				if(tempList.contains(String.valueOf(currEle.charAt(c)))){
					continue;
				}
				//else if(tempList.isEmpty()) {
					//System.out.println(currEle.charAt(c));
					//strBldr.append(currEle.charAt(c) + "\n");
					//tempList.add(currStr);
					
					//tempList.add(".");
			//	} 
			else if('.' == currEle.charAt(c)) {
					strBldr.append("-");
					//System.out.println("#####");										
				} else {
					for(int i = 0; i < tempList.size(); i++) {
						if(currEle.contains(tempList.get(i))) {
							strBldr.append("-");
						}
					}
					if(!tempList.contains(currEle.charAt(c))) {
						strBldr.append(currEle.charAt(c));
						tempList.add(currStr);
					}
					
					strBldr.append("\n");
				}
			}
			//print output and reset string builder
			System.out.println(strBldr);
			resultList.add(strBldr.toString());
			strBldr.delete(0, strBldr.length());
		}
		return resultList;
	}
}