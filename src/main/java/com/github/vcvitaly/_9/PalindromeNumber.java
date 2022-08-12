package com.github.vcvitaly._9;

/**
 * PalindromeNumber.
 *
 * @author Vitalii Chura
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String xString = String.valueOf(x);
        return xString.equals(new StringBuilder(xString).reverse().toString());
    }
}
