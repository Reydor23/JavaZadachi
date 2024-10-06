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
public class Teacher {
    Scanner sc = new Scanner(System.in);
    
    private String teacherTitle;
    private int numberOfCabinet;
    private int[] ocenki;
    private int broiDisciplini;
    private double sredenUspeh;
    
     
    public double sredenUspeh()
    {
        System.out.printf("Enter number of disciplini: ");
        broiDisciplini = sc.nextInt();
        
        ocenki = new int[broiDisciplini];
        
        int sum = 0;
        
        for (int i = 0; i < broiDisciplini; i++) 
        {
            System.out.printf("Enter grade for the discpicline: %d\n", i+1);
            ocenki[i] = sc.nextInt();
            sum += ocenki[i];
        }
             
        sredenUspeh = (double) sum / broiDisciplini;
        
        System.out.printf("Average grade: %.2f\n", sredenUspeh);
        return sredenUspeh;
       
    }
    
}
