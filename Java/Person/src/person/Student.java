/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author stani
 */
public class Student 
{
    Scanner sc = new Scanner(System.in);
    private String speciality;
    private int studentId;
    ArrayList<String> courses = new ArrayList<>();
    
    public void createAndShowProgram()
    {
        System.out.println("Enter the number of courses in the student's program: ");
        int numCourses = sc.nextInt();
        sc.nextLine();      
        
        for (int i = 0; i < numCourses; i++) {
            System.out.printf("Enter the name of course %d: ", i + 1);
            String courseName = sc.nextLine();
            courses.add(courseName);  
        }
        
        System.out.println("\nStudent's Program (Courses):");
        
        for (String course : courses) {
            System.out.println(course);
        }
     
    }
    
}
