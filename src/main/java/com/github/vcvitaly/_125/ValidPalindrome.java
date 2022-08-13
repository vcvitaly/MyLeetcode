package com.github.vcvitaly._125;

/**
 * ValidPalindrome.
 *
 * @author Vitalii Chura
 */
public class ValidPalindrome {

    public boolean isPalindromeViaRegex(String s) {
        String alphaNumericLowercaseS = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        String alphaNumericLowercaseReverseS = new StringBuilder(alphaNumericLowercaseS).reverse().toString();
        return alphaNumericLowercaseS.equals(alphaNumericLowercaseReverseS);
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (isAlphaNumeric(aChar)) {
                sb.append(aChar);
            }
        }
        return sb.toString().toLowerCase().equals(sb.reverse().toString().toLowerCase());
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}
