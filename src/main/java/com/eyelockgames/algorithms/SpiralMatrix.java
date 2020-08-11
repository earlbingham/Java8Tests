package com.eyelockgames.algorithms;

import java.util.*;

public class SpiralMatrix {

    public static void main(String[] args) {
        HashMap<Integer, String> tokens = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean isFirst = true;
        int row = 0;
        while(scanner.hasNext()) {
            tokens.put(row, scanner.nextLine());
            row++;
        }
        traverseSpiralMatrix(tokens);
    }

    private static void traverseSpiralMatrix(HashMap<Integer, String> tokens) {
        List<String> topRow = Arrays.asList(tokens.get(0).split(" "));
        String[][] matrix = new String[tokens.size()-1][tokens.size()-1];
        //construct the matrix
        for(int i = 0; i < tokens.size()-1; i++) {
            List<String> curRow = Arrays.asList(tokens.get(i+1).split(" "));
            for (int j = 0; j < tokens.size()-1; j++) {
                matrix[i][j] = curRow.get(j);
            }
        }

        //now go over it
        int top = 0;
        int right = tokens.size()-2;
        int bottom = tokens.size()-2;
        int left = 0;
        // Assuming when row is decremented this will be true..
        while(top < tokens.size()/2) {
            // traverse top
            for(int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            // traverse right
            for(int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            // traverse bottom
            for(int i = right; i >= left; i--) {

                System.out.print(matrix[bottom][i] + " ");
            }
            bottom--;
            // traverse left
            for(int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + " ");
            }
            left++;
        }
    }
}
