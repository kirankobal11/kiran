package com.deloitte.demo;

import java.util.function.Function;

public class AddDemo {

	public static void main(String[] args) {
		

		Function<String, Integer> obj = str -> str.length();
		
		int num = obj.apply("abc");
		
		System.out.println(num);
		
		
	}

}