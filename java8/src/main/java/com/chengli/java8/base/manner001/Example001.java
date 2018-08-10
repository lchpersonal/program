package com.chengli.java8.base.manner001;

import com.chengli.java8.base.Employee;
import com.chengli.java8.base.EmployeeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chengli
 * @Date: 2018/8/10 21:01
 * <p>
 * 通过普通方式实现：
 * 1. 筛选出年龄小于28岁的
 * 2. 筛选出工资大于5000的
 * 3. 筛选出工资小于2000的
 */
public class Example001 {

    private static final List<Employee> EMPLOYEES = EmployeeUtil.getEmployeeList();


    @Test
    public void test(){
        System.out.println(filterByAge$28());
        System.out.println(filterBySalary$$5000());
        System.out.println(filterBySalary$2000());
    }

    /**
     * 筛选出年龄小于18的
     *
     * @return
     */
    public List<Employee> filterByAge$28() {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : EMPLOYEES) {
            if (employee.getAge() < 28) {
                list.add(employee);
            }
        }
        return list;
    }

    /**
     * 筛选出工资大于5000的
     * @return
     */
    public List<Employee> filterBySalary$$5000() {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() > 5000) {
                list.add(employee);
            }
        }
        return list;
    }

    /**
     * 筛选出工资小于2000的
     * @return
     */
    public List<Employee> filterBySalary$2000() {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < 2000) {
                list.add(employee);
            }
        }
        return list;
    }
}
