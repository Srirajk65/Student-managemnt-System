package org.example;

import java.time.LocalDate;
import java.util.*;

import java.time.format.DateTimeFormatter;

public class StudentOperations {
    Scanner scan = new Scanner(System.in);
    private void filterByGrade(List<StudentRecord> studentRecords){
        System.out.println("Enter Grade to get student List : ");
        String grade = scan.nextLine();
        System.out.println();
        Grade fGrade = Grade.Nil;
        try {
             fGrade = Grade.valueOf(grade);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid grade string");
        }
        int i = 1 ;
        for(StudentRecord s : studentRecords){
            if(s.getGrade().equals(fGrade)){
                System.out.println("Student Info : " + i++);
                printStudent(s);
            }
        }
    }

    private void filterByPercentage(List<StudentRecord> studentRecords){
        System.out.println("Enter base percentage to get student List : ");
        int fPercentage = scan.nextInt();
        System.out.println();
        int i = 1 ;
        for(StudentRecord s : studentRecords){
            if(s.getPercentage() > fPercentage){
                System.out.println("Student Info : " + i++);
                printStudent(s);
            }
        }
    }
    private void searchByName(List<StudentRecord> studentRecords){
        System.out.println("Enter Student name to search : ");
        String sName = scan.nextLine();
        System.out.println();
        int i = 1;
        for(StudentRecord s : studentRecords){
            if(s.getName().equals(sName)){
                System.out.println("Student Info : " + i++);
                printStudent(s);
            }
        }
    }

    private void searchByClass(List<StudentRecord> studentRecords){
        System.out.println("Enter Class to search : ");
        String sClass = scan.nextLine();
        System.out.println();
        int i = 1;
        for(StudentRecord s : studentRecords){
            if(s.getName().equals(sClass)){
                System.out.println("Student Info : " + i++);
                printStudent(s);
            }
        }
    }
    private void printStudent(StudentRecord student){
        System.out.println("Name : " + student.getName());
        System.out.println("DOB : " + student.getDOB().toString());
        System.out.println("Class : " + student.getClassValue());
        System.out.println("Percentage : " + student.getPercentage());
        System.out.println("Grade : " + student.getGrade());
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
    }
    public void showAllStudents(List<StudentRecord> studentRecords){
        int i = 1;
        System.out.println("---------------------- List of All Students ----------------------");
        for(StudentRecord s : studentRecords){
            System.out.println("Student Info : " + i++);
            printStudent(s);
        }
    }

    private Map<Subject , Integer> getMarksforSubject(StudentRecord s){
        int mark = 0;
        Map<Subject , Integer> marks = new HashMap<>();
        for(Subject sub : s.getMarks().keySet()){
            System.out.println("Enter marks for " + sub.toString() + " : ");
            mark = scan.nextInt();
            marks.put(sub , mark);
        }
        return marks;
    }
    private void updateMarks(List<StudentRecord> studentRecords){
        System.out.println("Enter student name to update Marks");
        String uName = scan.nextLine();
        for(StudentRecord s : studentRecords){
            if(s.getName().equals(uName)){
                s.setMark(getMarksforSubject(s));
                break;
            }
        }
    }

    private void updateDOB(List<StudentRecord> studentRecords){
        System.out.println("Enter Student Name : ");
        String uName = scan.nextLine();
        System.out.println("Enter Date to Update : ");
        String uDate = scan.nextLine();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Parse the input string into a LocalDate
        LocalDate parsedDate = LocalDate.parse(uDate, dateFormatter);
        for(StudentRecord s : studentRecords){
            if(s.getName().equals(uName)){
                s.setDOB(parsedDate);
                break;
            }
        }
    }
    public void filterStudents(List<StudentRecord> studentRecords){
        //filter by rank
        System.out.println("---------------------Filter Students ------------------------------");
        int choice = 0;
        System.out.println("1. Filter by Grade ");
        System.out.println("2. Filter by Percentage");
        choice = scan.nextInt();
        switch(choice){
            case 1 : filterByGrade(studentRecords);
                break;
            case 2 : filterByPercentage(studentRecords);
                break;
            default: System.out.println("Invalid Choice !! ");
        }
    }

    public void searchForStudent(List<StudentRecord> studentRecords){
        int choice = 1;
        System.out.println("---------------------Search Students --------------------------------");
        System.out.println("1. Search by name ");
        System.out.println("2. Search by Class");
        choice = scan.nextInt();
        switch(choice){
            case 1 : searchByName(studentRecords);
                    break;
            case 2 : searchByClass(studentRecords);
                    break;
            default: System.out.println("Invalid Choice !! ");
        }
    }

    public void updateStudentRecord(List<StudentRecord> studentRecords){
        System.out.println("---------------------Update Student --------------------------------");
        System.out.println("Enter Student name to Update Info : ");
        String uName = scan.nextLine();
        System.out.println();
        int choice = 0;
        System.out.println("1. Update Marks");
        System.out.println("2. Update Update DOB");
        choice = scan.nextInt();
        switch(choice){
            case 1 : updateMarks(studentRecords); break;
            case 2 : updateDOB(studentRecords); break;
            default : System.out.println("Invalid Choice !!!");
        }

    }

    public void deleteStudent(List<StudentRecord> studentRecords) {
        System.out.println("---------------------Delete Student --------------------------------");
        System.out.print("Enter Student name to Delete : ");
        String dName = scan.nextLine();
        Iterator<StudentRecord> iterator = studentRecords.iterator();
        while (iterator.hasNext()) {
            StudentRecord s = iterator.next();
            if (s.getName().equals(dName)) {
                System.out.println("Student Found, Do you want to delete this information? Y/N ");
                printStudent(s);
                String choice = scan.nextLine();
                if (choice.equals("Y")) {
                    iterator.remove(); // Safely remove the element using iterator
                    System.out.println("Student deleted successfully.");
                }
                break;
            }
        }
    }
}
