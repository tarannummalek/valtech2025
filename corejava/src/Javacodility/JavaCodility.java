package Javacodility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaCodility {
	public static void main(String[] args) {

		String[] sortedSentences = sortByVowelCount(new String[] { "sdsds vgg", "aeiou", "fdfdffdf yuyuuu" });
		System.out.println(sortedSentences[0]);
		System.out.println(sortedSentences[1]);
		System.out.println(sortedSentences[2]);
	}

	static int vowelCount(String sentence) {
		int count = 0;
		for (char c : sentence.toCharArray()) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				count++;
			}

			return count;
		}
		return count;

	}

	String ratePassword(String password) {
		if (password.length() < 6) {
			return "Password length is short";
		}
		boolean hasLetter = false, hasDigit = false, hasSpecialChar = false;
		String specialChars = "!@#$%^&*()-+=<>?/{}[]|";
		for (char ch : password.toCharArray()) {
			if (Character.isLetter(ch))
				hasLetter = true;
			else if (Character.isDigit(ch))
				hasDigit = true;
			else if (specialChars.indexOf(ch) != -1)
				hasSpecialChar = true;
		}
		if (hasLetter && hasDigit && hasSpecialChar && password.length() >= 8) {
			return "Strong";
		} else if (hasLetter && hasDigit) {
			return "Medium";
		} else {
			return "Weak";
		}
	}

	static String[] sortByVowelCount(String[] sentences) {

		Map<String, Integer> vowelCounts = new HashMap<String, Integer>();

		for (String sentence : sentences) {
			vowelCounts.put(sentence, vowelCount(sentence));
		}
		List<String> sorted = vowelCounts.entrySet().stream().sorted((e, e1) -> e.getValue() - e1.getValue())
				.map(e -> e.getKey()).toList();
		System.out.println(sorted);

		return sentences;
	}
}
