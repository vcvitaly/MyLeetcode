package com.github.vcvitaly._844;

/**
 * BackspaceStringCompare.
 *
 * @author Vitalii Chura
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        return processBackspaces(s).equals(processBackspaces(t));
    }

    private String processBackspaces(String s) {
        int starCount = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                starCount++;
            } else if (starCount > 0) {
                starCount--;
            } else {
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }
}
