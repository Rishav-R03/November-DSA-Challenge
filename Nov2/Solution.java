package Nov2;

import java.util.*;

class Solution {
    public String solution(String str) {
        // Separate letters and digits
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            } else if (Character.isDigit(c)) {
                digits.add(c);
            }
        }

        // Sort both lists in ascending order
        Collections.sort(letters);
        Collections.sort(digits);

        int letterCount = letters.size();
        int digitCount = digits.size();

        // Check if rearrangement is possible
        if (Math.abs(letterCount - digitCount) > 1) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        // Determine which group to start with based on rules
        if (letterCount > digitCount) {
            // More letters - start with letters
            buildResult(result, letters, digits);
        } else if (digitCount > letterCount) {
            // More digits - start with digits
            buildResult(result, digits, letters);
        } else {
            // Equal counts - digits get preference
            buildResult(result, digits, letters);
        }

        return result.toString();
    }

    private void buildResult(StringBuilder result, List<Character> first, List<Character> second) {
        int i = 0, j = 0;

        // Alternate between the two lists
        while (i < first.size() || j < second.size()) {
            if (i < first.size()) {
                result.append(first.get(i));
                i++;
            }
            if (j < second.size()) {
                result.append(second.get(j));
                j++;
            }
        }
    }
}

/**
 * Custom Test Cases:
 * 
 * Test Case 1: "z3b1a2"
 * Input: "z3b1a2"
 * Expected: "1a2b3z" - Sorted digits and letters interleaved starting with
 * digits
 * 
 * Test Case 2: "q56"
 * Input: "q56"
 * Expected: "5q6" - More digits, so start with digits
 * 
 * Test Case 3: "ab12"
 * Input: "ab12"
 * Expected: "1a2b" - Equal counts, digits get preference
 * 
 * Test Case 4: "abc"
 * Input: "abc"
 * Expected: "" - Too many letters (3 letters, 0 digits)
 * 
 * Test Case 5: "123"
 * Input: "123"
 * Expected: "" - Too many digits (3 digits, 0 letters)
 * 
 * Test Case 6: "a1b2c3"
 * Input: "a1b2c3"
 * Expected: "1a2b3c" - Equal counts, digits get preference
 * 
 * Test Case 7: "x5y"
 * Input: "x5y"
 * Expected: "5xy" - More letters, so start with digits? Wait, 2 letters vs 1
 * digit
 * Actually: 2 letters, 1 digit -> |2-1| = 1, so possible. More letters so start
 * with letters: "x5y"
 * But according to example 2: "q56" -> "5q6" (more digits start with digits)
 * So for "x5y": 2 letters, 1 digit -> more letters so start with letters: "x5y"
 */