import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RobotDelivery {

    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        final List<Thread> threads = getThreads();

        // Ожидание завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Поиск самого частого количества R
        Map.Entry<Integer, Integer> mostFrequent = sizeToFreq.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.printf("Самое частое количество повторений %d (встретилось %d раз)%n",
                mostFrequent.getKey(), mostFrequent.getValue());

        System.out.println("Другие размеры:");

        // Вывод остальных значений по убыванию частоты
        sizeToFreq.forEach((key, value) -> {
            if (key != mostFrequent.getKey()) {
                System.out.printf("- %d (%d раз)%n", key, value);
            }
        });
    }

    private static List<Thread> getThreads() {
        int totalRoutes = 1000;
        List<Thread> threads = new ArrayList<>();

        // Запуск потоков
        for (int i = 0; i < totalRoutes; i++) {
            Thread thread = new Thread(() -> {
                String route = generateRoute("RLRFR", 100);

                // Подсчёт количества 'R'
                int countR = 0;
                for (char c : route.toCharArray()) {
                    if (c == 'R') {
                        countR++;
                    }
                }

                // Потокобезопасное обновление мапы
                synchronized (RobotDelivery.class) {
                    sizeToFreq.merge(countR, 1, Integer::sum);
                }
            });
            threads.add(thread);
            thread.start();
        }
        return threads;
    }

    public static String generateRoute(String letters, int length) {
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = ThreadLocalRandom.current().nextInt(letters.length());
            route.append(letters.charAt(index));
        }
        return route.toString();
    }
}