package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		System.out.println(intersect(new int[] {1,2,2,1}, new int[] {2,2}));
    }

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> m1 = new HashMap<>();
		Map<Integer, Integer> m2 = new HashMap<>();

		for (int i : nums1) {
			m1.put(i, m1.getOrDefault(i, 0) + 1);
		}

		for (int i : nums2) {
			m2.put(i, m2.getOrDefault(i, 0) + 1);
		}

		if(m1.size() > m2.size()) {
			return find(m1, m2);
		} else {
			return find(m2, m1);
		}
		
	}
	
	public static int[] find(Map<Integer, Integer> m1, Map<Integer, Integer> m2) {
		List<Integer> li = new ArrayList<>(m1.size());
		for(Map.Entry<Integer, Integer> entry : m1.entrySet()) {
			if(m2.containsKey(entry) 
					&& entry.getValue() == m2.get(entry)) {
				for(int x=0;x<entry.getValue();x++) {
					li.add(entry.getKey());
				}
			}
		}
		int[] res = new int[li.size()];
		int x = 0;
		for(Integer i : li) {
			res[x] = i;
			x++;
			System.out.println(i);
		}
		return res;
	}
	
}
