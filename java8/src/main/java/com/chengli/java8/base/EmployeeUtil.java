package com.chengli.java8.base;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: chengli
 * @Date: 2018/8/10 21:10
 */
public class EmployeeUtil {

    public static List<Employee> getEmployeeList() {
        Employee[] employees = {
                new Employee("张三", 18, 5555),
                new Employee("李四", 50, 8888),
                new Employee("王五", 32, 5125),
                new Employee("赵六", 25, 9999),
                new Employee("田七", 42, 1999),
                new Employee("孙九", 19, 2352),

        };
        return Arrays.asList(employees);
    }
}
