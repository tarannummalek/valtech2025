package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class EnhancedUtilTest {

	@Test
	void testListConventional() {
		
		List<Integer> nums=new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		System.out.println(nums);
		List<Integer> nums1= Arrays.asList(1,2,3,4);
		assertEquals(nums,nums1);
	}
	
	@Test
	void testMapsConventional() {
		Map<String,Integer> nums=new HashMap<String,Integer>();
		nums.put("One", 1);
		nums.put("Two", 2);
		nums.put("Three", 3);
		nums.put("Four", 4);
	}
	
	@Test
	public void testList() {
		List<Integer> nums=List.of(1,2,3,4);
		try {
			nums.add(4);
			fail("immutable list expected !");
			
		}catch(Exception e) {
			
		}
		List<Integer> nums1=new ArrayList<Integer>();
		nums1.addAll(nums);
		
		
	}
	
	@Test
	public void testMap() {
		Map<String ,Integer> nums=Map.of("One",1,"Two",2);
		nums.put("three", 3);
		
	}

}
