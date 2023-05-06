package com.zyj.leetcode.stream;

import com.alibaba.fastjson.JSON;
import com.zyj.leetcode.common.entity.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetCode
 * @Package: com.zyj.leetcode.stream
 * @ClassName: groupby
 * @Author: honor
 * @Description: groupby
 * @Date: 2023/5/6 14:17
 * @Version: 1.0
 */
@Slf4j
public class GroupBy {
    public static List<Student> students;
    public static List<Student> students2;

    static {
        students = Arrays.asList(
                new Student("apple", "男", 10.0),
                new Student("banana", "男", 10.0),
                new Student("orange", "男", 20.0),
                new Student("pipe", "女", 40.0),
                new Student("pinck", "女", 80.0)
        );
        students2 = Arrays.asList(
                new Student("apple2", "男", 10.0),
                new Student("banana2", "男", 10.0),
                new Student("orange2", "男", 20.0),
                new Student("pipe2", "女", 40.0),
                new Student("pinck2", "女", 80.0)
        );
    }

    public static void test1() {
        final Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getSex));
        log.info(JSON.toJSONString(map));

        final Map<String, Map<Double, List<Student>>> map1 = students.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.groupingBy(Student::getAge)));
        log.info(JSON.toJSONString(map1));

        final Map<String, Double> map2 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.summingDouble(Student::getAge)));
        log.info(JSON.toJSONString(map2));

        Map<String, List<String>> nameMap = students.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.mapping(Student::getName, Collectors.toList())));
        log.info(JSON.toJSONString(nameMap));


        final Map<Student, List<Student>> map3 = students.stream().collect(Collectors.groupingBy(p -> getSameSex(students2, p), Collectors.mapping((Student p) -> p, Collectors.toList())));
        log.info(JSON.toJSONString(map3));

    }

    private static Student getSameSex(List<Student> students, Student p) {
        final Optional<Student> any = students.stream().filter(e -> e.getName().contains(p.getName())).findAny();
        return any.get();
    }

    public static void main(String[] args) {
        test1();
    }
}
