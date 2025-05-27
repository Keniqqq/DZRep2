import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // имя хоста
        int port = 8080;           // порт сервера
        String name = "TestClient"; // имя, которое отправит клиент

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Подключились к серверу");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(name); // отправляем строку серверу

            String response = in.readLine(); // читаем ответ
            System.out.println("Ответ от сервера: " + response);
        } catch (IOException e) {
            System.err.println("Ошибка при подключении к серверу: " + e.getMessage());
        }
    }
}