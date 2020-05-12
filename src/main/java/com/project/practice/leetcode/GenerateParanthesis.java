package com.project.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Recursive backtracking approach
 * Time O((4 raise to power n) / square root(n)) - could not understand
 * Space O(n)
 */
public class GenerateParanthesis {

    public static void main(String[] args) {
        generate(3);
    }

    public static void generate(int n){
        List<String> result = new ArrayList<>();
        backtrack(result,"", 0,0, n);
        result.forEach(System.out::println);
    }

    public static void backtrack(List<String> result,
                                 String cur, int open, int close, int max){
        if (cur.length() == max*2){
            result.add(cur);
            return;
        }

        if ( open < max )
            backtrack(result, cur + "(", open + 1, close, max);
        if ( close < open)
            backtrack(result, cur + ")", open, close  + 1, max);
    }
}
