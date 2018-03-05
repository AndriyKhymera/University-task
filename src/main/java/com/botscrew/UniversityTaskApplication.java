package com.botscrew;

import com.botscrew.enums.LecturerDegree;
import com.botscrew.service.DepartmentService;
import com.botscrew.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class UniversityTaskApplication implements CommandLineRunner {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private LectorService lectorService;

    public static void main(String[] args) {
        SpringApplication.run(UniversityTaskApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Scanner stringScanner = new Scanner(System.in);
        Scanner numScanner = new Scanner(System.in);
        String departmentName = "";

        boolean work = true;
        while (work) {
            int choise = getMenuItemPick();

            switch (choise) {
                case 1: {
                    System.out.print("Enter department name: ");
                    departmentName = stringScanner.next();
                    System.out.println(departmentService.getHeadOfDepartmentByName(departmentName));
                    break;
                }
                case 2: {
                    System.out.print("Enter department name: ");
                    departmentName = stringScanner.next();
                    System.out.println(departmentService.getDepartmentStatistic(departmentName));
                    break;
                }
                case 3: {
                    System.out.print("Enter department name: ");
                    departmentName = stringScanner.next();
                    System.out.println(departmentService.getAverageSalary(departmentName));
                    break;
                }
                case 4: {
                    System.out.print("\nEnter department name: ");
                    departmentName = stringScanner.next();
                    System.out.println(departmentService.getEmployeesAmount(departmentName));
                    break;
                }
                case 5: {
                    System.out.println("Enter search phrase:");
                    String searchWord = stringScanner.next();
                    System.out.println(lectorService.findByRegex(searchWord));
                    break;
                }
                case 6: {
                    System.out.println("Create new department");
                    System.out.println("Enter a department name:");
                    departmentName = stringScanner.next();
                    departmentService.saveDepartment(departmentName);
                    break;
                }
                case 7: {
                    System.out.println("Enter lecturer name");
                    String name = stringScanner.next();
                    System.out.println("Enter lecturer surname");
                    String surname = stringScanner.next();
                    System.out.println("Enter lecturer salary");
                    int salary = numScanner.nextInt();
                    System.out.println("Choose one of three deegress:");
                    Arrays.stream(LecturerDegree.values()).forEach(System.out::print);
                    LecturerDegree degree = LecturerDegree.valueOf(stringScanner.next());
                }
                case 0: {
                    work = false;
                    break;
                }
                default: {
                    System.out.println("\nThere is no such option.");
                    break;
                }
            }
        }
    }

    public static int getMenuItemPick() {
        System.out.println("\n*****Univesity*****");
        System.out.println("1. Department head.");
        System.out.println("2. Department statistic.");
        System.out.println("3. Department average salary.");
        System.out.println("4. Department employee count.");
        System.out.println("5. Search for lecturer.");
        System.out.println("6. Add new department.");
        System.out.println("0. Exit.");
        System.out.print("Choose your option:");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
