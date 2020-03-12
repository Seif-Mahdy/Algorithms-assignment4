package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       // System.out.println("Enter number of test cases:");
        int numberOfTestCases = input.nextInt();
        ArrayList<Integer>results = new ArrayList<>();
        while (numberOfTestCases>0)
        {
            numberOfTestCases--;
            int numberOfVertexes,numberOfEdges;
           // System.out.println("Enter number of vertexes:");
            numberOfVertexes=input.nextInt();
           // System.out.println("Enter number of edges:");
            numberOfEdges=input.nextInt();
            Graph graph = new Graph(numberOfVertexes);
            for(int i=0;i<numberOfEdges;i++)
            {
                int source,destination;
               // System.out.println("Enter the source:");
                source = input.nextInt();
                //System.out.println("Enter the destination:");
                destination = input.nextInt();
                graph.addEdge(source,destination);
            }
            results.add(graph.getTheMaxConnectedComponent());
        }
        for (Integer result : results) {
            System.out.println(result);
        }

    }
}
