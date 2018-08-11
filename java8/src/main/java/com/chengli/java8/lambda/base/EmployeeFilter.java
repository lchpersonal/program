package com.chengli.java8.lambda.base;

/**
 * @Author: chengli
 * @Date: 2018/8/10 21:39
 */
@FunctionalInterface
public interface EmployeeFilter {
    boolean accept(Employee employee);
}
