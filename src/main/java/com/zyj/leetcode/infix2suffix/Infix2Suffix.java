package com.zyj.leetcode.infix2suffix;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

/**
 * 中缀表达式转后缀表达式
 *
 * @ProjectName: leet
 * @Package: com.stu.infix2suffix
 * @ClassName: Infix2Suffix
 * @Author: honor
 * @Description:
 * @Date: 2023/4/19 17:00
 * @Version: 1.0
 */
@Slf4j
@Data
public class Infix2Suffix {

    private static Stack<String> stack;
    private static List<Character> characterList = new ArrayList<>();
    private static List<String> outputList;

    static {
        characterList.add('+');
        characterList.add('-');
        characterList.add('*');
        characterList.add('/');
        characterList.add('(');
        characterList.add(')');
    }

    public static List<String> doTrans(String input) {
        List<String> inputArray = inputStrToArray(input);
        stack = new Stack();
        outputList = new ArrayList<>();
        for (int i = 0; i < inputArray.size(); i++) {
            final String str = inputArray.get(i);
//            log.info("For " + str + " " + stack);
            switch (str) {
                case "+":
                case "-":
                    getOperStr(str, 1);
                    break;
                case "*":
                case "/":
                    getOperStr(str, 2);
                    break;
                case "(":
                    stack.push(str);
                    break;
                case ")":
                    //遇到右括号，把括号中的操作符，添加到后缀表达式字符串中。
                    getParenStr();
                    break;
                default:
                    outputList.add(str);
                    break;
            }
        }
//        log.info("While " + Arrays.asList(stack));
        while (!stack.isEmpty()) {
            outputList.add(stack.pop());
        }

        return outputList;
    }

    private static List<String> inputStrToArray(String input) {
        final char[] chars = input.toCharArray();
        int start = 0;
        List<String> eleList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            final char c = input.charAt(i);
            if (characterList.contains(c)) {
                if (start != i) {
                    final String ele = input.substring(start, i);
                    eleList.add(ele);
                }
                start = i + 1;
                eleList.add(String.valueOf(c));
            } else {
                if (i == chars.length - 1) {
                    final String ele = input.substring(start);
                    eleList.add(ele);
                }
            }
        }
        return eleList;
    }

    /**
     * 从input获得操作符
     *
     * @param opThis
     * @param currentPriority 操作符的优先级
     */
    private static void getOperStr(String opThis, int currentPriority) {
        while (!stack.isEmpty()) {
            String opTop = stack.pop();
            //括号有较高优先级重新压入栈中
            if (Objects.equals(opTop, "(")) {
                stack.push(opTop);
                break;
            } else {
                int stackTopPriority;
                //+ ，-优先级都是1
                if (Objects.equals(opTop, "+") || Objects.equals(opTop, "-")) {
                    stackTopPriority = 1;
                } else {
                    stackTopPriority = 2;
                }
                //如果当前优先级大于栈顶部的优先级，重新压入栈中，否则出栈加入到后缀表达式字符串中
                if (stackTopPriority < currentPriority) {
                    stack.push(opTop);
                    break;
                } else {
                    outputList.add(opTop);
                }
            }
        }
        stack.push(opThis);
    }

    private static void getParenStr() {
        while (!stack.isEmpty()) {
            String chx = stack.pop();
            //如果是'('直接返回，其他操作符直接拼接到后缀表达式中。
            if (Objects.equals(chx, "(")) {
                break;
            } else {
                outputList.add(chx);
            }
        }
    }


    public static void main(String[] args) {
        log.info(String.valueOf(Infix2Suffix.doTrans("aa+bb-cc")));
//
        log.info(String.valueOf(Infix2Suffix.doTrans("A+B-C")));
//
        log.info(String.valueOf(Infix2Suffix.doTrans("A+B*C")));
        log.info("---------");

        log.info(String.valueOf(Infix2Suffix.doTrans("A*(B+C)")));
        log.info("---------");

        log.info(String.valueOf(Infix2Suffix.doTrans("A+B*(C-D)")));
        log.info("---------");
    }
}
