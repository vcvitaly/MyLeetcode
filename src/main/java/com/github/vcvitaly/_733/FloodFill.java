package com.github.vcvitaly._733;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * FloodFill.
 *
 * @author Vitalii Chura
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origColor = image[sr][sc];
        if (origColor == color) {
            return image;
        }
        Stack<CellIndex> stack = new Stack<>();
        stack.push(new CellIndex(sr, sc));
        while (!stack.isEmpty()) {
            CellIndex currentCell = stack.pop();
            image[currentCell.i][currentCell.j] = color;
            for (CellIndex unvisitedNeighborCoordinate :
                    unvisitedNeighborCoordinates(image, currentCell.i, currentCell.j, origColor)) {
                stack.push(unvisitedNeighborCoordinate);
            }
        }
        return image;
    }

    private List<CellIndex> unvisitedNeighborCoordinates(
            int[][] image, int i, int j, int origColor) {
        List<CellIndex> neighborCoordinates = new ArrayList<>();

        if (i-1 >= 0 && image[i-1][j] == origColor) {
            neighborCoordinates.add(new CellIndex(i-1,j));
        }
        if (j+1 < image[0].length && image[i][j+1] == origColor) {
            neighborCoordinates.add(new CellIndex(i, j+1));
        }
        if (i+1 < image.length && image[i+1][j] == origColor) {
            neighborCoordinates.add(new CellIndex(i+1,j));
        }
        if (j-1 >= 0 && image[i][j-1] == origColor) {
            neighborCoordinates.add(new CellIndex(i, j-1));
        }

        return neighborCoordinates;
    }

    private static class CellIndex {
        private int i;
        private int j;

        public CellIndex() {
        }

        public CellIndex(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
