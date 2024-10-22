/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

/**
 *
 * @author stani
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            Scanner scanner = new Scanner(System.in);
            String serverResponse;

            // Четене на съобщения от сървъра
            while ((serverResponse = in.readLine()) != null) {
                System.out.println(serverResponse);

                if (serverResponse.contains("Ваш ред")) {
                    // Клиентът трябва да подаде валидно число
                    System.out.print("Вашето предложение: ");
                    String guess = scanner.nextLine().trim(); // Използваме trim() за премахване на излишни интервали
                    if (guess.isEmpty()) {
                        System.out.println("Моля, въведете валидно число!");
                    } else {
                        out.println(guess); // Изпращаме въведеното число на сървъра
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
