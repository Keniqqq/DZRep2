import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 8080; // порт, на котором будет работать сервер

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);

            while (true) {
                System.out.println("Ожидаем подключения...");
                Socket clientSocket = serverSocket.accept(); // ждем подключения клиента

                System.out.println("Клиент подключён");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String name = in.readLine();
                int clientPort = clientSocket.getPort();

                System.out.printf("Получено сообщение от клиента: %s (порт: %d)%n", name, clientPort);

                out.printf("Hi %s, your port is %d%n", name, clientPort);
            }
        } catch (IOException e) {
            System.err.println("Ошибка в работе сервера: " + e.getMessage());
        }
    }
}