package org.example;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------Student Management System------------------------------");
//        Prefetch action = new Prefetch();
//        List<StudentRecord> studentRecords = action.getSampleDate(); // Populate Students from JSON .

        StudentOperations SO = new StudentOperations();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Show all Students");
            System.out.println("2. Filter Students based on criteria");
            System.out.println("3. Search for a Student"); // Based on Name | Test : Rachel
            System.out.println("4. Update a Student's Record");
            System.out.println("5. Delete a Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    SO.showAllStudents(Prefetch.studentRecords);
                    break;
                case 2:
                    SO.filterStudents(Prefetch.studentRecords); // By Class , By Grade
                    break;
                case 3:
                    SO.searchForStudent(Prefetch.studentRecords); // Name
                    break;
                case 4:
                    SO.updateStudentRecord(Prefetch.studentRecords); // Update Mark
                    break;
                case 5:
                    SO.deleteStudent(Prefetch.studentRecords); //Delete from Object .
                    break;
                case 6:
                    System.out.println("Exiting the Student Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            if(choice == 6) break;
        }

        scanner.nextInt();
    }
}