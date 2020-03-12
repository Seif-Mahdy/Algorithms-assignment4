package com.company;

import java.util.Arrays;

public class Graph{
    private int numberOfVertexes;
    private int numberOfEdges;
    private Edge[] edges;


    public Graph(int numberOfVertexes, int numberOfEdges) {
        this.numberOfVertexes = numberOfVertexes;
        this.numberOfEdges = numberOfEdges;
       edges = new Edge[numberOfEdges];
       for(int i=0;i<numberOfEdges;i++)
       {
           edges[i] = new Edge();
       }
    }
    private int find(Subset[] subsets, int vertex)
    {
        if(subsets[vertex].getParent()!=vertex)
        {
            subsets[vertex].setParent(find(subsets,subsets[vertex].getParent()));
        }
        return subsets[vertex].getParent();
    }
    private void union(Subset[] subsets , int source , int destination)
    {
        int sourceParent = find(subsets,source);
        int destinationParent = find(subsets,destination);
        if(subsets[sourceParent].getRank() < subsets[destinationParent].getRank())
        {
            subsets[sourceParent].setParent(destinationParent);
        }
        else if(subsets[sourceParent].getRank() > subsets[destinationParent].getRank())
        {
            subsets[destinationParent].setParent(sourceParent);
        }
        else
        {
            subsets[destinationParent].setParent(sourceParent);
            subsets[sourceParent].setRank(subsets[sourceParent].getRank()+1);
        }

    }
    public void addEdge(int index,int source,int destination,int weight)
    {
        edges[index] = new Edge(source,destination,weight);
    }
    public int  kruskal()
    {
        int result=0;
        Arrays.sort(edges);

        Subset[] subsets = new Subset[numberOfVertexes];

        for(int i=0;i<numberOfVertexes;i++)
        {
            subsets[i] = new Subset();
        }
        for(int i=0;i<numberOfVertexes;i++)
        {
            subsets[i].setParent(i);
            subsets[i].setRank(0);
        }

        for (Edge edge : edges) {
            int source = find(subsets, edge.getSource());
            int destination = find(subsets, edge.getDestination());
            if (source != destination) {
                result += edge.getWeight();
                union(subsets, source, destination);
            }
        }
        return result;
    }
    public int getNumberOfVertexes() {
        return numberOfVertexes;
    }

    public void setNumberOfVertexes(int numberOfVertexes) {
        this.numberOfVertexes = numberOfVertexes;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public void setNumberOfEdges(int numberOfEdges) {
        this.numberOfEdges = numberOfEdges;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }
}
