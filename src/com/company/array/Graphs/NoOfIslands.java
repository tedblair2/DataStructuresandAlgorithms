package com.company.array.Graphs;

public class NoOfIslands {

    public void numberIslands(char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for (int i=0;i<m;i++){//row
            for (int j=0;j<n;j++){//column
                if (!visited[i][j] && grid[i][j]=='1'){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        System.out.println("Number of islands is "+count);
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j]=='0') {
            return;
        }
        visited[i][j]=true;
        dfs(grid,i,j-1,visited);//go left
        dfs(grid,i-1,j,visited);//go up
        dfs(grid,i,j+1,visited);//go right
        dfs(grid,i+1,j,visited);//go down
    }

    public static void main(String[] args){
        NoOfIslands no=new NoOfIslands();
        char[][] grid={{'1','1','0','0'},
                {'1','0','0','0'},
                {'0','0','1','0'},
                {'0','0','0','1'}};
        no.numberIslands(grid);
    }
}
