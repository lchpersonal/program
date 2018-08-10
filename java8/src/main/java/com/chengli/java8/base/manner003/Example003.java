package com.chengli.java8.base.manner003;

import com.chengli.java8.base.Employee;
import com.chengli.java8.base.EmployeeFilter;
import com.chengli.java8.base.EmployeeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chengli
 * @Date: 2018/8/10 21:36
 * <p>
 * 通过匿名内部类来实现
 * 传lambda表达式和传递匿名对象差不多，但是比匿名对象更简洁
 */
public class Example003 {
    private static final List<Employee> EMPLOYEES = EmployeeUtil.getEmployeeList();

    @Test
    public void test() {
        System.out.println(employeeFilter(new EmployeeFilter() {
            @Override
            public boolean accept(Employee employee) {
                return employee.getAge() < 28;
            }
        }));
        System.out.println(employeeFilter(new EmployeeFilter() {
            @Override
            public boolean accept(Employee employee) {
                return employee.getSalary() > 5000;
            }
        }));
        System.out.println(employeeFilter(new EmployeeFilter() {
            @Override
            public boolean accept(Employee employee) {
                return employee.getSalary() < 2000;
            }
        }));

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
