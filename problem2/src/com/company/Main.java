package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int numberOfVertexes,numberOfEdges,graphSum=0;
        Scanner input = new Scanner(System.in);
        while(true)
        {
            numberOfVertexes = input.nextInt();
            numberOfEdges = input.nextInt();
            if(numberOfEdges==0&&numberOfVertexes==0)
            {
                break;
            }
            Graph graph = new Graph(numberOfVertexes,numberOfEdges);
            int source,destination,weight;
            for(int i=0;i<numberOfEdges;i++)
            {
                source = input.nextInt();
                destination = input.nextInt();
                weight = input.nextInt();
                graph.addEdge(i,source,destination,weight);
                graphSum+=weight;
            }
            System.out.println(graphSum-graph.kruskal());



        }
    }
}
