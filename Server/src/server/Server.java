/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

/**
 *
 * @author stani
 */
import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Server {
    private static final int PORT = 12345;
    private static final int TIME_LIMIT = 15; // Времеви лимит в секунди
    private static final Object lock = new Object();
    private static int secretNumber; // Тайното число, което трябва да се отгатне
    private static boolean gameWon = false;

    public static void main(String[] args) throws IOException {
        System.out.println("Сървърът е стартиран...");
        secretNumber = (int) (Math.random() * 100) + 1; // Генерираме тайно число между 1 и 100
        System.out.println("Тайното число е: " + secretNumber); // Само за тестовете, да се вижда числото

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Нов клиент се свърза.");
                new Thread(new ClientHandler(socket)).start();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Добре дошли в играта! Опитайте да отгатнете тайното число (между 1 и 100).");

                while (!gameWon) {
                    synchronized (lock) {
                        if (gameWon) break;

                        out.println("Ваш ред! Въведете число (1-100):");

                        socket.setSoTimeout(TIME_LIMIT * 1000); // Таймаут от 15 секунди

                        try {
                            String guess = in.readLine();
                            if (guess == null || guess.isEmpty()) {
                                out.println("Няма въведено число! Редът ви беше пропуснат.");
                                continue;
                            }

                            int guessNumber;
                            try {
                                guessNumber = Integer.parseInt(guess); // Преобразуване на входа в число
                            } catch (NumberFormatException e) {
                                out.println("Невалидно число! Моля, въведете цяло число.");
                                continue; // Пропускаме този опит и продължаваме
                            }

                            // Проверка на числото
                            if (guessNumber == secretNumber) {
                                out.println("Познахте! Тайното число беше " + secretNumber);
                                gameWon = true;
                                out.println("Играта приключи. Победител сте!");
                                System.out.println("Клиент позна числото! Играта приключва.");
                                resetGame();
                            } else if (guessNumber < secretNumber) {
                                out.println("Тайното число е по-голямо.");
                            } else {
                                out.println("Тайното число е по-малко.");
                            }
                        } catch (SocketTimeoutException e) {
                            out.println("Времето ви изтече! Преминава се към следващия клиент.");
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Рестартиране на играта след победа
        private void resetGame() {
            synchronized (lock) {
                secretNumber = (int) (Math.random() * 100) + 1;
                gameWon = false;
                System.out.println("Нов рунд започна. Тайното число е: " + secretNumber);
            }
        }
    }
}