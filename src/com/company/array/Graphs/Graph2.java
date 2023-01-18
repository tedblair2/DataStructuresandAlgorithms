package com.company.array.Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph2 {
    LinkedList<Integer>[] adj;

    public Graph2(int nodes){
        this.adj=new LinkedList[nodes];
        for (int i=0;i<nodes;i++){
            this.adj[i]=new LinkedList<>();
        }
    }
    private void addEdge(int u,int v){
        this.adj[u].add(v);
        this.adj[v].add(u);
    }
    private void printgraph(LinkedList<Integer>[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.println(i+"-->"+arr[i]);
        }
    }
    private void breadthFirstSearch(int s){
        int vertices=adj.length;
        boolean[] visited=new boolean[vertices];
        Queue<Integer> queue=new LinkedList<>();
        visited[s]=true;
        queue.offer(s);
        while (!queue.isEmpty()){
            int u=queue.poll();
            System.out.print(u+" ");
            for (int v:adj[u]){
                if(!visited[v]){
                    visited[v]=true;
                    queue.offer(v);
                }
            }
        }
    }
    private void itereativeDFS(int s){
        int vertices=adj.length;
        boolean[] visited=new boolean[vertices];
        Stack<Integer> stack=new Stack<>();
        stack.push(s);
        System.out.println();
        while (!stack.isEmpty()){
            int u=stack.pop();
            if (!visited[u]){
                visited[u]=true;
                System.out.print(u+" ");
                for (int v:adj[u]){
                    if (!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
    }
    private void recursiveDFS(int s){
        int vertices=adj.length;
        System.out.println();
        boolean[] visited=new boolean[vertices];
        for (int v=0;v<vertices;v++){
            if (!visited[v]){
                dfs(v,visited);
            }
        }
    }

    private void dfs(int v, boolean[] visited){
        visited[v]=true;
        System.out.print(v+" ");
        for (int w:adj[v]){
            if (!visited[w]){
                dfs(w,visited);
            }
        }
    }

    public static void main(String[] args){
        Graph2 graph2=new Graph2(5);
        graph2.addEdge(0,1);
        graph2.addEdge(1,2);
        graph2.addEdge(2,3);
        graph2.addEdge(3,0);
        graph2.addEdge(2,4);
        graph2.printgraph(graph2.adj);
        graph2.breadthFirstSearch(0);
        graph2.itereativeDFS(0);
        graph2.recursiveDFS(0);

    }
}
