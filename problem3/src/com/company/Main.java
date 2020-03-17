package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int c , s , q;
        Queue<ArrayList<String>> queue = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        c=input.nextInt();
        s=input.nextInt();
        q=input.nextInt();
        while (c != 0 || s!= 0 || q!=0) {
            int[][] adjacencyMatrix = new int[c][c];
            ArrayList<String>outputs = new ArrayList<>();
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    adjacencyMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < s; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                int decibels = input.nextInt();
                adjacencyMatrix[start - 1][end - 1] = decibels;
            }
            calculateAllShortestPaths(adjacencyMatrix);
            for (int i = 0; i < q; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                if (adjacencyMatrix[start - 1][end - 1] == Integer.MAX_VALUE) {
                    outputs.add("no path");
                } else {
                    outputs.add(String.valueOf(adjacencyMatrix[start - 1][end - 1]));
                }
            }
            c=input.nextInt();
            s=input.nextInt();
            q=input.nextInt();
            queue.add(outputs);
        }
        int i=1;
        while (!queue.isEmpty()){
            System.out.println("Case #"+i++);
            ArrayList<String>outputs = queue.remove();
            for(String output:outputs){
                System.out.println(output);
            }
        }
    }
    public static void calculateAllShortestPaths(int [][] matrix){
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix.length ; j++){
                for(int s=0 ; s<matrix.length; s++){
                    matrix[j][s] = matrix[s][j] = Math.min(matrix[j][s], Math.max(matrix[j][i],matrix[i][s]));
                }
            }
        }
    }
}
