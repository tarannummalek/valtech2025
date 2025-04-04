package Javacodility;

import java.util.Arrays;

public class PhoneNumberRemembering {

    static int getEaseOfRememberingScore(long number) {
        String numberStr = String.valueOf(number);
        if (numberStr.matches("(\\d)\\1*")) {
            return 3;
        }
        if (numberStr.length() % 2 == 0) {
            String firstHalf = numberStr.substring(0, numberStr.length() / 2);
            String secondHalf = numberStr.substring(numberStr.length() / 2);
            if (firstHalf.equals(secondHalf)) {
                return 2;
            }
        }
        for (int i = 1; i < numberStr.length(); i++) {
            if (numberStr.charAt(i) != numberStr.charAt(i - 1) + 1) {
                return 1;
            }
        }
        return 1;
    }

    public static long[] sortMobileNumbers(long[] mobileNos) {
        Long[] boxedNumbers = Arrays.stream(mobileNos).boxed().toArray(Long[]::new);
        Arrays.sort(boxedNumbers, (a, b) -> Integer.compare(getEaseOfRememberingScore(b), getEaseOfRememberingScore(a)));
        return Arrays.stream(boxedNumbers).mapToLong(Long::longValue).toArray();
    }

    public static void main(String[] args) {
        long[] mobileNos = {123123, 987654, 111222, 555555, 12312345, 222333, 111111};
        long[] sortedNumbers = sortMobileNumbers(mobileNos);
        for (long number : sortedNumbers) {
            System.out.print(number + " ");
        }
    }
}
