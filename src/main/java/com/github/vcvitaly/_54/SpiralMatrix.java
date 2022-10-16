package com.github.vcvitaly._54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SpiralMatrix.
 *
 * @author Vitalii Chura
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        int circleCount = 0;
        int minSide = Math.min(matrix.length, matrix[0].length);
        int maxCircleCount = minSide / 2 + minSide % 2;
        while (circleCount < maxCircleCount) {
            for (; j < matrix[0].length - circleCount; j++) {
                res.add(matrix[i][j]);
            }
            i++;
            if (i >= matrix.length - circleCount) {
                break;
            }
            j--;
            for (; i < matrix.length - circleCount; i++) {
                res.add(matrix[i][j]);
            }
            j--;
            if (j < circleCount) {
                break;
            }
            i--;
            for (; j >= circleCount; j--) {
                res.add(matrix[i][j]);
            }
            i--;
            if (i < circleCount) {
                break;
            }
            j++;
            for (; i > circleCount; i--) {
                res.add(matrix[i][j]);
            }
            j++;
            if (j >= matrix[0].length - circleCount) {
                break;
            }
            i++;
            circleCount++;
        }

        return res;
    }
}
