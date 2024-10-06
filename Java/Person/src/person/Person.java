/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package person;

import java.util.Scanner;

/**
 *
 * @author stani
 */
public class Person {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose:\n1.Person\n2.Teacher\n3.Student\n4.School Student");
        System.out.println("Choose: ");
        int choose = sc.nextInt();
        
        switch(choose)
        {
            case 1: 
                PersonClass firstPerson = new PersonClass();
                firstPerson.Info();
                break;
            case 2: 
                Teacher teacher = new Teacher();
                teacher.sredenUspeh();
                break;
            case 3:
                Student student = new Student();
                student.createAndShowProgram();
                break;
            case 4:
                SchoolStudent scStudent = new SchoolStudent();
                scStudent.Input();            
                scStudent.Output();
        }
        
        
        
       
    
      
    }
    
}
