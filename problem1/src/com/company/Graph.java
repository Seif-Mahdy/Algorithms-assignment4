package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    int numberOfVertexes;
    LinkedList<Integer>[]adjacencyList;

    Graph(int numberOfVertexes)
    {
        this.numberOfVertexes=numberOfVertexes;
        adjacencyList = new LinkedList[numberOfVertexes+1];
        for(int i=0;i<numberOfVertexes+1;i++)
        {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }
    void addEdge(int source , int destination)
    {

            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source);

    }
    void dfs(int root , boolean[] visited,ArrayList<Integer>connectedComponent)
    {
        visited[root]=true;
        connectedComponent.add(root);
        for(int i : adjacencyList[root])
        {
            if(!visited[i])
            {
                dfs(i,visited,connectedComponent);
            }
        }
    }
    int getTheMaxConnectedComponent()
    {
        ArrayList<ArrayList<Integer>>connectedComponents=new ArrayList<>();
        boolean[] visited = new boolean[numberOfVertexes+1];
        for(int i=0;i<numberOfVertexes;i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer>connectedComponent = new ArrayList<>();
                dfs(i,visited,connectedComponent);
                connectedComponents.add(connectedComponent);
            }
        }
        int max=0;
        for (ArrayList<Integer> connectedComponent : connectedComponents) {
            if (connectedComponent.size() > max) {
                max = connectedComponent.size();
            }
        }
        return max;
    }

}
