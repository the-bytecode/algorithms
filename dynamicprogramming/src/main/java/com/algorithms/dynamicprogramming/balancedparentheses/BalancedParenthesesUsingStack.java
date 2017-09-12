package com.algorithms.dynamicprogramming.balancedparentheses;

import java.util.Stack;

/**
 * Created by chandrashekar.v on 4/25/2017.
 */
public class BalancedParenthesesUsingStack {
    private static final char[][] TOKENS = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    public static void main(String[] args) {
        String parentheses = "{()[{({})[]()}]}([]){{}}]";
        System.out.println("Is Valid: " + validateParentheses(parentheses));
    }

    private static boolean validateParentheses(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (Character c : parentheses.toCharArray()) {
            if (isOpenTerm(c)) {
                stack.push(c);
            } else {
                if (stack.empty() || !isMatches(stack.pop(), c))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatches(Character openTerm, Character closedTerm) {
        for (char[] array : TOKENS) {
            if (array[0] == openTerm)
                return array[1] == closedTerm;
        }
        return false;
    }

    private static boolean isOpenTerm(Character c) {
        for (char[] array : TOKENS) {
            if (array[0] == c)
                return true;
        }
        return false;
    }


}
