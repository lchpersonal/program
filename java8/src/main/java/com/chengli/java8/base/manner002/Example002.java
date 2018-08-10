package com.chengli.java8.base.manner002;

import com.chengli.java8.base.Employee;
import com.chengli.java8.base.EmployeeFilter;
import com.chengli.java8.base.EmployeeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chengli
 * @Date: 2018/8/10 21:25
 * <p>
 * 方式二：
 * 通过策略模式来实现特定条件员工的筛选
 */
public class Example002 {

    private static final List<Employee> EMPLOYEES = EmployeeUtil.getEmployeeList();

    @Test
    public void test() {
        System.out.println(employeeFilter(new Age$28EmployeeFilter()));
        System.out.println(employeeFilter(new Salary$$5000EmployeeFilter()));
        System.out.println(employeeFilter(new Salary$2000EmployeeFilter()));

    }

    public List<Employee> employeeFilter(EmployeeFilter filter) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : EMPLOYEES) {
            if (filter.accept(employee)) {
                list.add(employee);
            }
        }
        return list;
    }
}
