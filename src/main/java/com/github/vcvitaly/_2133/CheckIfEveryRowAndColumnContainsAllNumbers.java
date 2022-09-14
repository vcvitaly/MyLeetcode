package com.github.vcvitaly._2133;

import java.util.HashMap;
import java.util.Map;

/**
 * CheckIfEveryRowAndColumnContainsAllNumbers.
 *
 * @author Vitalii Chura
 */
public class CheckIfEveryRowAndColumnContainsAllNumbers {

    public boolean checkValid(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (!isValidRow(matrix, i)) {
                return false;
            }
        }
        for (int j = 0; j < matrix.length; j++) {
            if (!isValidColumn(matrix, j)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(int[][] matrix, int i) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int j = 0; j < matrix.length; j++) {
            countMap.merge(matrix[i][j], 1, Integer::sum);
        }
        for (int k = 1; k <= matrix.length; k++) {
            Integer count = countMap.get(k);
            if (count == null || count != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColumn(int[][] matrix, int j) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            countMap.merge(matrix[i][j], 1, Integer::sum);
        }
        for (int k = 1; k <= matrix.length; k++) {
            Integer count = countMap.get(k);
            if (count == null || count != 1) {
                return false;
            }
        }
        return true;
    }
}
