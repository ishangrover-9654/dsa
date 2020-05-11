package com.project.practice.arrays.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Recursive backtracking approach
 * Time O((4 raise to power n) / square root(n)) - could not understand
 * Space O(n)
 */
public class GenerateParanthesis {

    public static final int MAX = 2;
    public static void main(String[] args) {
        generate();
    }

    public static void generate(){
        List<String> result = new ArrayList<>();
        backtrack(result,"", 0,0);
        result.forEach(System.out::println);
    }

    public static void backtrack(List<String> result, String cur, int open, int close){
        if (cur.length() == MAX*2){
            result.add(cur);
            return;
        }

        if ( open < MAX )
            backtrack(result, cur + "(", open + 1, close);
        if ( close < open)
            backtrack(result, cur + ")", open, close  + 1);
    }
}
