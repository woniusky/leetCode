package com.zyj.leetcode.infix2suffix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

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

    public static final String SPLIT_SEPARATOR = "__";

    public static BigDecimal solveUnknownsExp(SolveUnknownsParam param) {
        if (param == null || param.getUnknowns() == null) {
            return null;
        }
        List<String> inputList = transferAssembleUnknowns(param);
        return doParse(inputList, param);
    }

    private static List<String> transferAssembleUnknowns(SolveUnknownsParam param) {
        final List<String> strings = Infix2Suffix.doTrans(param.getLeft());
        for (int i = 0; i < strings.size(); i++) {
            final Object o = param.getUnknownsMap().get(strings.get(i));
            if (o != null) {
                strings.set(i, o.toString());
            }
        }
        return strings;
    }

    public static BigDecimal doParse(List<String> input, SolveUnknownsParam param) {
        Stack<Object> stack = new Stack<>();
        List<MathExpress> mathExpresses = new ArrayList<>();
        String ch;
        BigDecimal num1 = BigDecimal.ZERO;
        BigDecimal num2 = BigDecimal.ZERO;
        BigDecimal interAns;
        for (int i = 0; i < input.size(); i++) {
            ch = input.get(i);
            if (Boolean.TRUE.equals(isNum(ch)) || Objects.equals(ch, param.getUnknowns())) {
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
                    express.setLeft(obj1 + SPLIT_SEPARATOR + ch + SPLIT_SEPARATOR + obj2);
                    express.setOperator(String.valueOf(ch));
                    express.setRight(param.getUnknowns() + mathExpresses.size());
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
                        interAns = num1.divide(num2, param.getScale(), BigDecimal.ROUND_HALF_UP);
                        break;
                    default:
                        interAns = BigDecimal.ZERO;
                        break;
                }
                stack.push(interAns);
            }
        }
        if (param.getRight() == null || Objects.equals(param.getRight(), "")) {
            return new BigDecimal(stack.pop().toString());
        }
        // 求解未知数
        return solveUnknowns(param, mathExpresses);
    }

    /**
     * 求解未知数
     *
     * @return
     */
    private static BigDecimal solveUnknowns(SolveUnknownsParam param, List<MathExpress> mathExpresses) {
        if (mathExpresses.isEmpty()) {
            return null;
        }
        final int size = mathExpresses.size();
        final MathExpress lastExp = mathExpresses.get(size - 1);
        lastExp.setRight(String.valueOf(param.getRight()));
        boolean first = false;
        for (int i = size - 1; i >= 0; i--) {
            if (i == 0) {
                first = true;
            }
            final MathExpress express = mathExpresses.get(i);
            switch (express.getOperator()) {
                case "+": {
                    final String[] split = express.getLeft().split(SPLIT_SEPARATOR+"\\+"+SPLIT_SEPARATOR);
                    String newRight;
                    BigDecimal bigDecimal1;
                    BigDecimal bigDecimal2;
                    // 加数 + 加数 = 和，所以 加数 = 和 - 另一个加数
                    if (split[0].contains(param.getUnknowns())) {
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
                    final String[] split = express.getLeft().split(SPLIT_SEPARATOR + express.getOperator() + SPLIT_SEPARATOR);
                    String newRight;
                    // 减数 - 被减数 = 差，所以 减数 = 差 + 被减数
                    if (split[0].contains(param.getUnknowns())) {
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
                    final String[] split = express.getLeft().split(SPLIT_SEPARATOR + "\\*" + SPLIT_SEPARATOR);
                    String newRight = "";
                    // 乘数 * 乘数 = 积， 所以 乘数 = 积 / 另一个乘数
                    BigDecimal bigDecimal1 = new BigDecimal(express.getRight());
                    BigDecimal bigDecimal2;
                    if (split[0].contains(param.getUnknowns())) {
                        bigDecimal2 = new BigDecimal(split[1]);
                    } else {
                        bigDecimal2 = new BigDecimal(split[0]);
                    }
                    newRight = bigDecimal1.divide(bigDecimal2, param.getScale(), BigDecimal.ROUND_HALF_UP).toPlainString();
                    if (first) {
                        return new BigDecimal(newRight);
                    } else {
                        final MathExpress preExp = mathExpresses.get(i - 1);
                        preExp.setRight(newRight);
                    }
                    break;
                }
                case "/": {
                    final String[] split = express.getLeft().split(SPLIT_SEPARATOR + "\\/" + SPLIT_SEPARATOR);
                    String newRight;
                    // 被除数 / 除数 = 商， 所以 被除数 = 商 * 除数
                    if (split[0].contains(param.getUnknowns())) {
                        BigDecimal bigDecimal1 = new BigDecimal(express.getRight());
                        BigDecimal bigDecimal2 = new BigDecimal(split[1]);
                        newRight = bigDecimal1.multiply(bigDecimal2).toPlainString();
                    } else {
                        // 除数 = 被除数 / 商
                        BigDecimal bigDecimal1 = new BigDecimal(express.getRight());
                        BigDecimal bigDecimal2 = new BigDecimal(split[0]);
                        newRight = bigDecimal2.divide(bigDecimal1, param.getScale(), BigDecimal.ROUND_HALF_UP).toPlainString();
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

    public static Boolean isNum(Object obj) {
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

        SolveUnknownsParam solveUnknownsParam = new SolveUnknownsParam();
        solveUnknownsParam.setLeft(left);
        solveUnknownsParam.setUnknowns("x");
        solveUnknownsParam.setUnknownsMap(new HashMap<>());
        log.info("result>:{}", solveUnknownsExp(solveUnknownsParam));

        solveUnknownsParam.setLeft("-3-3.2*(x+5)-6/(1+2*3)");
        solveUnknownsParam.setRight(right);
        log.info("result>:{}", solveUnknownsExp(solveUnknownsParam));

    }
}
