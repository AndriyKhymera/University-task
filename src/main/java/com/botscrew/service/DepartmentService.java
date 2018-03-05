package com.botscrew.service;


import com.botscrew.entity.Lector;

import java.util.List;

public interface DepartmentService {
    String getHeadOfDepartmentByName(String departmentName);

    String getDepartmentStatistic(String departmentName);

    String getAverageSalary(String departmentName);

    String getEmployeesAmount(String departmentName);

    boolean saveDepartment(String name);

    boolean saveDepartment(String name, Lector lector, List<Lector> lectors);
}
