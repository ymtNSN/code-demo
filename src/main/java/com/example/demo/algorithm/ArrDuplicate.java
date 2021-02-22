package com.example.demo.algorithm;

import java.util.Stack;

/**
 * Created by @author ymtNSN on 2021/2/20
 */
public class ArrDuplicate {

    public static void main(String[] args) {
        String res = remove("bcac");
        System.out.println(res);
    }

    static String remove(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[256];
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c){
                if (count[stack.peek()] == 0){
                    break;
                }
                inStack[stack.pop()] = false;
            }

            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
//        return sb.reverse().toString();
        return sb.toString();
    }
}
