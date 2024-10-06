/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import java.util.Scanner;

/**
 *
 * @author stani
 */
public class SchoolStudent {
    Scanner sc = new Scanner(System.in);
    private int idStudent;
    private String nameOfSchool;
    
    public void Input()
    {
        System.out.println("Enter ID of student: ");
        idStudent = sc.nextInt(); 
        
        sc.nextLine();
        
        System.out.println("Enter name of School: ");
        nameOfSchool = sc.nextLine();    
    }
   
    
    public void Output()
    {
        System.out.printf("ID of student: %d\n", idStudent);
        System.out.print("Name of the School: " +  nameOfSchool + "\n");
    }
    
    
    
}
