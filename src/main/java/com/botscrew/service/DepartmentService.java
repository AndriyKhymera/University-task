package com.botscrew.service;


public interface DepartmentService {
    String getHeadOfDepartmentByName(String departmentName);

    String getDepartmentStatistic(String departmentName);

    String getAverageSalary(String departmentName);

    String getEmployeesAmount(String departmentName);
}
