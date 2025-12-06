package com.github.vcvitaly._118;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleSolver {

    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            result.add(getRow(i, result));
        }
        return result;
    }

    private List<Integer> getRow(int rowNum, List<List<Integer>> triangle) {
        if (rowNum == 1) {
            return List.of(1);
        }

        final int prevRowNum = rowNum - 1;
        final List<Integer> prevRow = triangle.get(prevRowNum - 1);
        final List<Integer> row = new ArrayList<>();
        row.add(prevRow.getFirst());
        for (int i = 1; i < rowNum; i++) {
            int leftParent = i - 1;
            int rightParent = Math.min(i, prevRowNum - 1);
            if (leftParent == rightParent) {
                row.add(prevRow.get(leftParent));
            } else {
                row.add(prevRow.get(leftParent) + prevRow.get(rightParent));
            }
        }

        return row;
    }
}
