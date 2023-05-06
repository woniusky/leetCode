package com.zyj.leetcode.common.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @ProjectName: leetCode
 * @Package: com.zyj.leetcode.common.entity
 * @ClassName: Studeng
 * @Author: honor
 * @Description: 实体
 * @Date: 2023/5/6 14:18
 * @Version: 1.0
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    String name;
    String sex;
    Double age;

    public Student(String name, String sex, Double age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
