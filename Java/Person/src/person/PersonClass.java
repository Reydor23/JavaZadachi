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
public class PersonClass 
{
    Scanner sc = new Scanner(System.in);
    private String name;
    private int age;
    private int phone;
    
    
    public void Info()
    {
        System.out.println("Enter name:");
        name = sc.nextLine();
        System.out.println("Enter age:");
        age = sc.nextInt();
        System.out.println("Enter phone number:");
        phone = sc.nextInt();
        
        System.out.println("All information: \n Name: " + name + "Age: "+ age+ "\n Phone: " + phone);
        
        
    }
   
    
    
}
