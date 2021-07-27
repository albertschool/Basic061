package com.company;

import java.util.Scanner;

public class Main { // 2-D Array

    public static boolean help2(int num) {
        if (num/1000 == 0 && num/100 > 0)
            return true;
        return false;
    }

    public static int ex2(int[][] arr) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (help2(arr[i][j]))
                    count++;
            }
        }
        return count;
    }

    public static void Q1() {
        int[][] mat1 = {{1000,900,800},
                {70,600,500},
                {200,100,90}};
        System.out.println(ex2(mat1));
    }

    public static boolean ex8(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length-1; j++) {
                if (!(arr[i][j] < arr[i][j+1]))
                    return false;
            }
        }
        return true;
    }

    public static void Q2() {
        int[][] mat1 = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        System.out.println(ex8(mat1));
        int[][] mat2 = {{1,2,3},
                {4,6,5},
                {7,8,9}};
        System.out.println(ex8(mat2));
    }

    public static int place(int[][] arr, int x) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (arr[i][j] != x) {
                    count++;
                } else {
                    return count;
                }
            }
        }
        return -1;
    }

    public static void printAndCount(int[][] arr, int prev1, int prev2) {
        int place1 = place(arr, prev1);
        int place2 = place(arr, prev2);
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (place1 <= count && count <= place2) {
                    System.out.print(arr[i][j]+",");
                }
                count++;
            }
        }
        System.out.println();
    }

    public static void Q3() {
        int[][] mat1 = {{39,72,3,8,0,2,54},
                {18,16,13,47,41,87,65},
                {34,78,37,99,97,46,56},
                {51,50,12,31,58,63,18},
                {23,4,11,26,83,25,67}};
        printAndCount(mat1,46,4);
    }

    public static boolean subArraySquare3Glow(int[][] arr, int k, int j, int num) {
        int sum = 0;
        for (int i=k; i<k+3; i++) {
            for (int l=j; l<j+3; l++) {
                sum += arr[i][l];
            }
        }
        if (sum >  num) {
            return true;
        } else {
            return false;
        }
    }

    public static void Q4() {
        Scanner input = new Scanner(System.in);
        int ROWS = 491;
        int COLUMNS = 67;
        System.out.println("Enter number to check sum of ArraySquare3Glow:");
        int num = input.nextInt();
        int[][] arr = new int[ROWS][COLUMNS];
/*        int[][] arr = {{39,72,3,8,0,2,54},
                {18,16,13,47,41,87,65},
                {34,78,37,99,97,46,56},
                {51,50,12,31,58,63,18},
                {23,4,11,26,83,25,67}};*/
        for (int i=0; i<arr.length-2; i++) {
            for (int j=0; j<arr[i].length-2; j++) {
                if (subArraySquare3Glow(arr,i,j,num)) {
                    for (int k=i; k<i+3; k++) {
                        for (int l=j; l<j+3; l++) {
                            System.out.print(arr[k][l]+",");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Q1();
        Q2();
        Q3();
        Q4();
    }
}
