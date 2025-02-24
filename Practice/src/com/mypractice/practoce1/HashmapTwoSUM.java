package com.mypractice.practoce1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashmapTwoSUM {

	public static void main(String[] args) {
	

		int[] num = { 2, 3, 6, 7, 4 };
		int target = 9;


		System.out.println(Arrays.toString(twoSum(num, target)));
	
	}
	
	
	public static int [] twoSum(int[] num, int target) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < num.length ; i++) {
			int complement = target - num[i];
			
			if(map.containsKey(complement)) {
				return new int [] {map.get(complement), i};
			}else {
				map.put(num[i], i);
			}
		}
		
		
		return null;
		
		
	}
}
