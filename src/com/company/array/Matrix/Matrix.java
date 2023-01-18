package com.company.array.Matrix;

public class Matrix {

    private void printMatrix(int[][] matrix){
        for (int i=0;i<matrix.length;i++){//returns number of rows
            for (int j=0;j<matrix[i].length;j++){//returns number of columns
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    private void searchMatrix(int[][] matrix,int n,int value){//searching a sorted matrix row and column wise
        int row=0;
        int column=n-1;
        while (row<n && column>=0){
            if (matrix[row][column]==value){
                System.out.println("Value is present on row "+(row+1)+" and column "+(column+1));
                return;
            }
            if (matrix[row][column]>value){
                column--;
            }else {
                row++;
            }
        }
        System.out.println("Value Not found");
    }
    private void printSpiral(int[][] matrix,int rows,int columns){
        int i,row=0,column=0;
        System.out.print("Matrix in spiral order: ");
        while (row<rows && column<columns){
            for (i=column;i<columns;i++){//traverse from left to right across a row
                System.out.print(matrix[row][i]+" ");
            }
            row++;
            for (i=row;i<rows;i++){//traverse from top to bottom along a column
                System.out.print(matrix[i][columns-1]+" ");
            }
            columns--;
            if (row<rows){
                for (i=columns-1;i>=column;i--){//traverse from right to left
                    System.out.print(matrix[rows-1][i]+" ");
                }
                rows--;
            }
            if (column<columns){
                for (i=rows;i>=row;i--){//traverse from bottom to top
                    System.out.print(matrix[i][column]+" ");
                }
                column++;
            }
        }

    }
    public static void main(String[] args){
        Matrix mtx=new Matrix();
        int[][] matrix={{1,3,5,7},
                {2,4,6,8},
                {4,6,8,10},
                {6,8,10,11}};
        mtx.printMatrix(matrix);
        //mtx.searchMatrix(matrix,4,12);
        mtx.printSpiral(matrix,4,4);

    }
}

