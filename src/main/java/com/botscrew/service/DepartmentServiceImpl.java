package com.botscrew.service;

import com.botscrew.Repository.DepartmentRepository;
import com.botscrew.entity.Department;
import com.botscrew.entity.Lector;
import com.botscrew.enums.LecturerDegree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public String getHeadOfDepartmentByName(String departmentName) {
        Optional<Department> department = departmentRepository.findByName(departmentName);
        if (!department.isPresent()) {
            return "Can't find that department! Check your spelling.";
        }

        Optional<Lector> head = department.get().getHead();

        if (!head.isPresent()) {
            return String.format("%s do not have head", departmentName);
        }

        return String.format("\nHead of %s department is %s %s\n", departmentName, head.get().getName(), head.get().getSurname());
    }

    @Override
    @Transactional
    public String getDepartmentStatistic(String departmentName) {
        Optional<Department> department = departmentRepository.findByName(departmentName);
        if (!department.isPresent()) {
            return "Can't find that department!Check your spelling.";
        }

        List<Lector> lectors = department.get().getLectors();

        int assistantsAmount = (int) lectors.stream().filter(lector -> lector.getDegree() == LecturerDegree.ASSISTANT).count();
        int associateAmount = (int) lectors.stream().filter(lector -> lector.getDegree() == LecturerDegree.ASSOCIATE_PROFESSOR).count();
        int professorsAmount = (int) lectors.stream().filter(lector -> lector.getDegree() == LecturerDegree.PROFESSOR).count();

        return String.format("\nAssistans - %d.\n" +
                "associate professors - %d\n" +
                "professors - %d", assistantsAmount, associateAmount, professorsAmount);
    }

    @Override
    @Transactional
    public String getAverageSalary(String departmentName) {
        Optional<Department> department = departmentRepository.findByName(departmentName);
        if (!department.isPresent()) {
            return "Can't find that department! Check your spelling.";
        }

        List<Lector> lectors = department.get().getLectors();
        double averageSalary = lectors.stream()
                .mapToDouble(lector -> lector.getSalary() / 100)
                .average()
                .getAsDouble();

        return String.format("\nThe average salary of %s is %s", departmentName, averageSalary);
    }

    @Override
    @Transactional
    public String getEmployeesAmount(String departmentName) {
        Optional<Department> department = departmentRepository.findByName(departmentName);
        if (!department.isPresent()) {
            return "Can't find that department!Check your spelling.";
        }
        List<Lector> lectors = department.get().getLectors();

        return String.format("\nAmount of employees: %d", lectors.size());
    }

}
