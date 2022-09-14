package com.github.vcvitaly._36;

import java.util.HashSet;
import java.util.Set;

/**
 * ValidSudoku.
 *
 * @author Vitalii Chura
 */
public class ValidSudoku {

    private static final int BOX_LENGTH = 9;
    private static final int SUB_BOX_LENGTH = 3;

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < BOX_LENGTH; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }
        for (int j = 0; j < BOX_LENGTH; j++) {
            if (!isValidColumn(board, j)) {
                return false;
            }
        }
        for (int i = 0; i < BOX_LENGTH; i += 3) {
            for (int j = 0; j < BOX_LENGTH; j += 3) {
                if (!isValidSubbox(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidRow(char[][] board, int i) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < BOX_LENGTH; j++) {
            char c = board[i][j];
            if (isDigit(c)) {
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int j) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < BOX_LENGTH; i++) {
            char c = board[i][j];
            if (isDigit(c)) {
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        return true;
    }

    private boolean isValidSubbox(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int k = i; k < i + SUB_BOX_LENGTH; k++) {
            for (int l = j; l < j + SUB_BOX_LENGTH; l++) {
                char c = board[k][l];
                if (isDigit(c)) {
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
        return true;
    }

    private boolean isDigit(char c) {
        return (c >= 48 && c <= 57);
    }
}
