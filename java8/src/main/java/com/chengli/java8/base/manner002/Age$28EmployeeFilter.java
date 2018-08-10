package com.chengli.java8.base.manner002;

import com.chengli.java8.base.Employee;
import com.chengli.java8.base.EmployeeFilter;

/**
 * @Author: chengli
 * @Date: 2018/8/10 21:32
 */
public class Age$28EmployeeFilter implements EmployeeFilter {
    @Override
    public boolean accept(Employee employee) {
        return employee.getAge() < 28;
    }
}
