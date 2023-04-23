package com.zyj.leetcode.infix2suffix;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 计算后缀表达式
 *
 * @ProjectName: leetCode
 * @Package: com.zyj.leetcode.infix2suffix
 * @ClassName: ComputeSuffixExp
 * @Author: honor
 * @Description:
 * @Date: 2023/4/20 11:07
 * @Version: 1.0
 */
@Slf4j
public class ComputeSuffixExp {

    private Stack<Object> stack;
    private List<MathExpress> mathExpresses;

    public BigDecimal doParse(List<String> input, Integer right) {
        stack = new Stack<>();
        mathExpresses = new ArrayList<>();
        String ch;
        BigDecimal num1 = BigDecimal.ZERO;
        BigDecimal num2 = BigDecimal.ZERO;
        BigDecimal interAns;
        for (int i = 0; i < input.size(); i++) {
            ch = input.get(i);
            log.info(" " + ch + " " + stack);
            if (Boolean.TRUE.equals(isNum(ch)) || Objects.equals(ch, "x")) {
                stack.push(ch);
            } else {
                final Object obj2 = stack.pop();
                final Object obj1 = stack.pop();
                final Boolean num1Flag = isNum(obj2);
                if (Boolean.TRUE.equals(num1Flag)) {
                    num2 = new BigDecimal(obj2.toString());
                }
                final Boolean num2Flag = isNum(obj1);
                if (Boolean.TRUE.equals(num2Flag)) {
                    num1 = new BigDecimal(obj1.toString());
                }
                if (!num1Flag || !num2Flag) {
                    MathExpress express = new MathExpress();
                    express.setLeft(obj1 + " " + ch + " " + obj2);
                    express.setOperator(String.valueOf(ch));
                    express.setRight("x" + mathExpresses.size());
                    mathExpresses.add(express);
                    stack.push(express.getRight());
                    continue;
                }
                switch (ch) {
                    case "+":
                        interAns = num1.add(num2);
                        break;
                    case "-":
                        interAns = num1.subtract(num2);
                        break;
                    case "*":
                        interAns = num1.multiply(num2);
                        break;
                    case "/":
                        interAns = num1.divide(num2, 2, BigDecimal.ROUND_HALF_UP);
                        break;
                    default:
                        interAns = BigDecimal.ZERO;
                        break;
                }
                stack.push(interAns);
            }
        }
        // 求解未知数
        return solveUnknowns(right);
    }

    /**
     * 求解未知数
     * @param right
     * @return
     */
    private BigDecimal solveUnknowns(Integer right) {
        if (mathExpresses.isEmpty()) {
            return null;
        }
        final int size = mathExpresses.size();
        final MathExpress lastExp = mathExpresses.get(size - 1);
        lastExp.setRight(String.valueOf(right));
        Boolean first = false;
        for (int i = size - 1; i >= 0; i--) {
            if (i == 0) {
                first = true;
            }
            final MathExpress express = mathExpresses.get(i);
            switch (express.getOperator()) {
                case "+": {
                    final String[] split = express.getLeft().split(" \\+ ");
                    String newRight = "";
                    BigDecimal bigDecimal1;
                    BigDecimal bigDecimal2;
                    // 加数 + 加数 = 和，所以 加数 = 和 - 另一个加数
                    if (split[0].contains("x")) {
                        bigDecimal1 = new BigDecimal(express.getRight());
                        bigDecimal2 = new BigDecimal(split[1]);
                    } else {
                        bigDecimal1 = new BigDecimal(express.getRight());
                        bigDecimal2 = new BigDecimal(split[0]);
                    }
                    newRight = bigDecimal1.subtract(bigDecimal2).toPlainString();
                    if (first) {
                        return new BigDecimal(newRight);
                    } else {
                        final MathExpress preExp = mathExpresses.get(i - 1);
                        preExp.setRight(newRight);
                    }
                    break;
                }
                case "-": {
                    final String[] split = express.getLeft().split(" " + express.getOperator() + " ");
                    String newRight;
                    // 减数 - 被减数 = 差，所以 减数 = 差 + 被减数
                    if (split[0].contains("x")) {
                        BigDecimal bigDecimal1 = new BigDecimal(express.getRight());
                        BigDecimal bigDecimal2 = new BigDecimal(split[1]);
                        newRight = bigDecimal1.add(bigDecimal2).toPlainString();
                    } else {
                        // 被减数 = 减数 - 差
                        BigDecimal bigDecimal1 = new BigDecimal(express.getRight());
                        BigDecimal bigDecimal2 = new BigDecimal(split[0]);
                        newRight = bigDecimal2.subtract(bigDecimal1).toPlainString();
                    }
                    if (first) {
                        return new BigDecimal(newRight);
                    } else {
                        final MathExpress preExp = mathExpresses.get(i - 1);
                        preExp.setRight(newRight);
                    }
                    break;
                }
                case "*": {
                    final String[] split = express.getLeft().split(" " + express.getOperator() + " ");
                    String newRight = "";
                    // 乘数 * 乘数 = 积， 所以 乘数 = 积 / 另一个乘数
                    BigDecimal bigDecimal1 = new BigDecimal(express.getRight());
                    BigDecimal bigDecimal2;
                    if (split[0].contains("x")) {
                        bigDecimal2 = new BigDecimal(split[1]);
                    } else {
                        bigDecimal2 = new BigDecimal(split[0]);
                    }
                    newRight = bigDecimal1.divide(bigDecimal2, 2, BigDecimal.ROUND_HALF_UP).toPlainString();
                    if (first) {
                        return new BigDecimal(newRight);
                    } else {
                        final MathExpress preExp = mathExpresses.get(i - 1);
                        preExp.setRight(newRight);
                    }
                    break;
                }
                case "/": {
                    final String[] split = express.getLeft().split(" " + express.getOperator() + " ");
                    String newRight = "";
                    // 被除数 / 除数 = 商， 所以 被除数 = 商 * 除数
                    if (split[0].contains("x")) {
                        BigDecimal bigDecimal1 = new BigDecimal(express.getRight());
                        BigDecimal bigDecimal2 = new BigDecimal(split[1]);
                        newRight = bigDecimal1.multiply(bigDecimal2).toPlainString();
                    } else {
                        // 除数 = 被除数 / 商
                        BigDecimal bigDecimal1 = new BigDecimal(express.getRight());
                        BigDecimal bigDecimal2 = new BigDecimal(split[0]);
                        newRight = bigDecimal2.divide(bigDecimal1, 2, BigDecimal.ROUND_HALF_UP).toPlainString();
                    }
                    if (first) {
                        return new BigDecimal(newRight);
                    } else {
                        final MathExpress preExp = mathExpresses.get(i - 1);
                        preExp.setRight(newRight);
                    }
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + express.getOperator());
            }
        }
        return null;
    }

    public Boolean isNum(Object obj) {
        try {
            new BigDecimal(obj.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        ComputeSuffixExp computeSuffixExp = new ComputeSuffixExp();
//        String left = "3-3.2*(4+5)-6/(x+2*3)";
        String left = "3-3.2*(4+5)-6/(1+2*3)";
//        String left = "3-3.2*(4+5)-6+(x+2-3)";

        String right = "25";
//        left = left+"-"+right;

        final List<String> strings = Infix2Suffix.doTrans(left);

        log.info(computeSuffixExp.doParse(strings, 25).toPlainString());
    }
}
