package com.botscrew.service;

import com.botscrew.Repository.DepartmentRepository;
import com.botscrew.entity.Department;
import com.botscrew.entity.Lector;
import com.botscrew.enums.LecturerDegree;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public String getHeadOfDepartmentByName(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        //TODO check whether deparment exists

        Lector head = department.getHead();
        //TODO if there is not head return some message.

        String message = String.format("Head of %s department is %s %s\n", departmentName, head.getName(), head.getSurname());
        return message;
    }

    @Override
    @Transactional
    public String getDepartmentStatistic(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        //TODO check whether department exists

        List<Lector> lectors = department.getLectors();

        int assistantsAmount = (int) lectors.stream().filter(lector -> lector.getDegree() == LecturerDegree.ASSISTANT).count();
        int associateAmount = (int) lectors.stream().filter(lector -> lector.getDegree() == LecturerDegree.ASSOCIATE_PROFESSOR).count();
        int professorsAmount = (int) lectors.stream().filter(lector -> lector.getDegree() == LecturerDegree.PROFESSOR).count();

        return String.format("Assistans - %d.\n" +
                "associate professors - %d\n" +
                "professors - %d", assistantsAmount, associateAmount, professorsAmount);
    }

    @Override
    @Transactional
    public String getAverageSalary(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        //TODO check whether department exists

        List<Lector> lectors = department.getLectors();
        double averageSalary = lectors.stream()
                .mapToDouble(lector -> lector.getSalary() / 100)
                .average()
                .getAsDouble();

        return String.format("The average salary of %s is %s", departmentName, averageSalary);
    }

    @Override
    @Transactional
    public String getEmployeesAmount(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        //TODO check whether department exists

        //ToDO create query to just get number
        List<Lector> lectors = department.getLectors();

        return String.format("Amount of employees: %d", lectors.size());

    }

}
