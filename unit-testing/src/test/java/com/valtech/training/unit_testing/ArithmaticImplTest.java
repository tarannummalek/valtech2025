package com.valtech.training.unit_testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ArithmaticImplTest {
	private Arithmatic arithmatic;
	
	@BeforeAll
	public static void beforAll() {
		System.out.println("before all ");
	}
	
	
	@BeforeEach
	public void some() {
		
		System.out.println("init");
		
		arithmatic=new ArithmaticImpl();
		
		
	}

	@Test
	void testAdd() {
		
		System.out.println("add");	
		assertEquals(9, arithmatic.add(4, 5));
		
	}

	@Test
	void testSub() {
		
		System.out.println("sub");	
		assertEquals(1, arithmatic.sub(6, 5));
		
	}
	
	
	@ParameterizedTest(name="add with csv file A={0} B={1} res={2}")
	@CsvFileSource(files="data.csv")
	void testAddWithCsvFile(int a, int b, int res) {
		assertEquals(res, arithmatic.add(a, b));
		
		
		
	}
	 static Stream <Arguments> addArgumentsProvider(){
		 return Stream.of(Arguments.of(2,3,5),Arguments.of(-2,3,1),Arguments.of(2,-3,-1));
		
	}
	@ParameterizedTest(name="add with csv sources A={0} B={1} res={2}")
	@CsvSource(value= {"2,3,5","-1,3,2","0,3,3","-1,-1,-2"})
	void testAddWithCsv(int a, int b, int res) {
		assertEquals(res, arithmatic.add(a, b));	
	}
	
	
	@ParameterizedTest(name="Add with Method source A={0} B={1} res={2}")
	@MethodSource(value="addArgumentsProvider")
	void testAddWithMethodSource(int a, int b, int res) {
		assertEquals(res, arithmatic.add(a, b));
		
		
		
	}
	
	
	@ParameterizedTest(name="Add with multi values")
	@ValueSource(strings= {"5,2,3" ,"0,-3,3"})
	
	
	void testAddAgain(String param) {//"5,2,3" ,"0,-3,-3"
		
		List<Integer> params=Arrays.asList(param.split(",")).stream().map(it->Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(params.get(0), arithmatic.add(params.get(2), params.get(1)));

		
	}
	
	
	

}
