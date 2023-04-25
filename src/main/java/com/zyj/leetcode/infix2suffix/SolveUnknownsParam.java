package com.zyj.leetcode.infix2suffix;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Map;

/**
 * @ProjectName: leetCode
 * @Package: com.zyj.leetcode.infix2suffix
 * @ClassName: SolveUnknownsParam
 * @Author: honor
 * @Description: 求解未知数入参
 * @Date: 2023/4/25 17:17
 * @Version: 1.0
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SolveUnknownsParam {
    String left;
    String right;
    Integer scale;
    String unknowns;
    Map<String, Object> unknownsMap;

    public Integer getScale() {
        if (scale == null) {
            return 2;
        }
        return scale;
    }
}
