package com.ashish.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MathExperiments {

	private int[] arr;
	public MathExperiments(int size) {
		arr = new int[size];
		
		Random rand = new Random(123);
		for (int i = 0; i<size; i++) {
			arr[i] = rand.nextInt(1000);
			System.out.println(arr[i]);
		}
	}
	
	/*
	 * Sorts the array which is a private member.
	 */
	public void Sort() {
		List<Integer> mylist = new ArrayList<Integer>();
		for (int i=0; i<arr.length; i++) {
			mylist.add(arr[i]);
		}
		
		Collections.sort(mylist);
		System.out.println("Printing in sorted order.");
		for(Integer x : mylist) {
			System.out.println(x.intValue());
		}
	}
	
	public static void main(String[] args) {
		MathExperiments exp = new MathExperiments(15);
		exp.Sort();
	}	

}
