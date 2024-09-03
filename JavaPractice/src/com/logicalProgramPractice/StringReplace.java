package com.logicalProgramPractice;

public class StringReplace {

public static void main(String[] args) {
	
 String s = "Manashri Gopalrao Bhojane";
 
 System.out.println(s.length());
 
 String[] strings = s.split(" ");
	
	for(int i=0; i<strings.length; i++) {
		
		if(strings[i].equals("Bhojane")) {
			
			strings[i] = "Malewar";
		}
		
	}
	
	/*
	 * String newString =" ";
	 * 
	 * for (String nwString :strings) {
	 * 
	 * 
	 * newString = newString+nwString+" "; 
	 * 
	 * }
	 * 
	 * s=newString.trim();
	 * 
	 * System.out.println(s);
	 * 
	 */
	
	StringBuffer sb = new StringBuffer();
	
	for(String ss :strings) {
		
		sb.append(ss+" ");
			
	}

	s=sb.toString().trim();
	
		System.out.println(s);
	}
	

}
