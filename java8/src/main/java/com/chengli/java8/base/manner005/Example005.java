package com.chengli.java8.base.manner005;

import com.chengli.java8.base.Employee;
import com.chengli.java8.base.EmployeeUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: chengli
 * @Date: 2018/8/10 21:36
 * <p>
 * 通过stream API来实现
 */
public class Example005 {
    private static final List<Employee> EMPLOYEES = EmployeeUtil.getEmployeeList();

    @Test
    public void test() {
        System.out.println(Arrays.asList(EMPLOYEES.stream().filter(employee -> employee.getAge() < 28).toArray()));
        System.out.println(Arrays.asList(EMPLOYEES.stream().filter(employee -> employee.getSalary() > 5000)));
        System.out.println(Arrays.asList(EMPLOYEES.stream().filter(employee -> employee.getSalary() < 2000)));
    }
}
