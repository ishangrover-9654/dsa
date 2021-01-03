package com.project.practice.leetcode.backtracking;

public class BeautifulArrangement_526 {
    static int count = 0;
    public static void main(String[] args) {
        System.out.println(countArrangement(2));
    }

    public static  int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        calculate(n,1, visited);
        return count;
    }

    public static void calculate(int n, int pos, boolean[] visited){
        if (pos > n)
            count++;
        for (int i = 1; i <= n; i++) {
            if (visited[i]==false && ((i % pos ==0) || (pos%i==0))){
                visited[i] = true;
                calculate(n, pos + 1, visited);
                visited[i] = false;
            }
        }

    }
}
