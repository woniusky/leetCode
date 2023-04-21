package com.zyj.leetcode.infix2suffix;

import lombok.Data;

/**
 * @ProjectName: leetCode
 * @Package: com.zyj.leetcode.infix2suffix
 * @ClassName: MathExpress
 * @Author: honor
 * @Description: 数学表达式
 * @Date: 2023/4/20 14:41
 * @Version: 1.0
 */
@Data
public class MathExpress {
    private String left;
    private String operator;
    private String right;
}
