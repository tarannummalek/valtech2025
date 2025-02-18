package StreamPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import org.junit.runner.JUnitCommandLineParseResult.CommandLineParserError;

public class StreamPractice {
 public static void main(String[] args) {
	
	 List<String> list=Arrays.asList("abc","def","ghi","jkl","mno","");
	 
	 List<String> listWithoutEmpty=list.stream().filter(e->e!="").toList();
	 //System.out.println(listWithoutEmpty);
	 
	 Map<String,Integer> length=list.stream().collect(Collectors.toMap(e->e, e->e.length()));
	 //System.out.println(length);
	 
	 List<Integer> list1=Arrays.asList(2,6,9,10,6,8,9,6,10,7);
	 //System.out.println(list1.stream().filter(e->e%2==0&&e%5==0).findFirst().orElse(0));
	 
	 long sum=list1.stream().filter(e->e%2!=0).map(e->e*e).reduce(0,(a,b)->{if(a>80) {return a
			 ;}else{return  a+b; }});
	 //System.out.println(sum);
	 
	 System.out.println(list1.stream().sorted((a,b)->b-a).skip(1).findFirst().orElse(1));
	 list1.stream().map(e->Collections.frequency(e, list1));
	 //list1.stream().mapToDouble(null)
	 
	 	
	 
	 
	 
 }

}
