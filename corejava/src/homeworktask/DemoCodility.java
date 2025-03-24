package homeworktask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoCodility {
	public static void main(String[] args) {
		
		String[] sortedSentences=sortByVowelCount(new String[]{"sdsds vgg","aeiou","fdfdffdf yuyuuu"});
		System.out.println(sortedSentences[0]);
		System.out.println(sortedSentences[1]);
		System.out.println(sortedSentences[2]);
	}
	int findEasyToRememberMobileNo(long[] mobileNos) {
		for(int i=0;i<mobileNos.length;i++);{
			
			
			
		}
		return 0;
		
		
	}
	
	
	int ratePassword(String password) {
		
		char[] chars=password.toCharArray();
		int rate=0;
		for(char c:chars) {
			//if(c=='!')
		}
		return 0;
		
	}
	static String[] sortByVowelCount(String[] sentences) {
		
		Map<String ,Integer> vowelCounts=new HashMap<String,Integer>();
		
		 for(String sentence:sentences) {
			 vowelCounts.put(sentence, vowelCount(sentence));
		 }
		 
		 List<String> sorted=vowelCounts.entrySet().stream().sorted((e,e1)->e.getValue()-e1.getValue()).map(e->e.getKey()).toList();
		 System.out.println(sorted);
		
		//String[] sortedSentences=new String[sentences.length];
		
//	for(int i=0;i<sentences.length-1;i++) {
//		for(int j=1;j<sentences.length-2;j++) {
//			if(vowelCount(sentences[i])>vowelCount(sentences[j])) {
//				String temp; 
//				temp=sentences[i];
//				sentences[i]=sentences[j];
//				sentences[j]=temp;
//				//System.out.println(i+j+);
//				
//			}
//				
//			}
//		}
		return sentences;
	}
	
	
	static int vowelCount(String sentence) {
		int count=0;
			for(char c:sentence.toCharArray()) {
				if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
					count++;
				}
				
				return count;
			}
			return count;
			
	
	
	}	
	
}
