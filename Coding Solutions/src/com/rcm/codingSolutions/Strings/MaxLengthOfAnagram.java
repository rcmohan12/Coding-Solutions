package com.rcm.codingSolutions.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class MaxLengthOfAnagram {

	public static void main(String[] args) {
		System.out.println(findMax(new String[] {"cat", "bat", "dog", "mood", "iojdfds", "why", "six"}, "gwohdy"));
    }
	
	public static List<String> findMax(String[] dict, String key) {
		List<String> maxStr = new ArrayList<>();
		List<String> keyList = new ArrayList<>(Arrays.asList(key.split("")));
		Map<Integer, List<String>> maxLengthMap = new TreeMap<>();
		int key1 = 0;
		
		List<String> strList = new ArrayList<>();
		
		for(String str : dict) {
			strList.clear();
			strList.addAll(Arrays.asList(str.split("")));
			if (keyList.size() > strList.size() && keyList.containsAll(strList)) {
				System.out.println("Match :" + str);
				key1 = Math.max(key1, str.length());
				if(maxLengthMap.containsKey(strList.size())) {
					maxLengthMap.get(strList.size()).add(str);
				} else {
					List<String> sArray = new ArrayList<>();
					sArray.add(str);
					maxLengthMap.put(strList.size(), sArray);
				}
			}
		}
		
		
		
		return maxLengthMap.get(key1);
	}
	
}
