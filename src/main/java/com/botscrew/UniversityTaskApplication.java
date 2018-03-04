package com.botscrew;

import com.botscrew.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan("com.botscrew")
public class UniversityTaskApplication implements CommandLineRunner {

    @Autowired
    private DepartmentService departmentService;

    public static void main(String[] args) {
        SpringApplication.run(UniversityTaskApplication.class, args);


    }

    @Override
    public void run(String... strings) throws Exception {
        Scanner stringScanner = new Scanner(System.in);
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
        System.out.println("\n\n*****Univesity*****");
        System.out.println("1. Department head.");
        System.out.println("2. Department statistic.");
        System.out.println("3. Department average salary.");
        System.out.println("4. Department employee count.");
        System.out.println("5. Search for lecturer.");
        System.out.println("0. Exit.");
        System.out.print("Choose your option:");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
