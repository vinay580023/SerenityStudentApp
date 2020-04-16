package com.studentapp.utils;

import java.util.Random;

public class TestUtils {

	public static String getRandomString(){
		
		Random randomnum = new Random();
		int randomint = randomnum.nextInt();
		return Integer.toString(randomint);
	}
}
