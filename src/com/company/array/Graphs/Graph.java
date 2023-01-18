package com.company.array.Graphs;

public class Graph {
    int[][] adjgraph;

    public Graph(int nodes){
        this.adjgraph=new int[nodes][nodes];
    }
    private void addEdge(int u,int v){
        this.adjgraph[u][v]=1;
        this.adjgraph[v][u]=1;
    }
    private void printMatrix(int[][] matrix){
        for (int i=0;i<matrix.length;i++){//returns number of rows
            for (int j=0;j<matrix[i].length;j++){//returns number of columns
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Graph graph=new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.printMatrix(graph.adjgraph);
    }
}
