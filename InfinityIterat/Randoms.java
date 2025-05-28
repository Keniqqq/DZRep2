import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private final int min;
    private final int max;
    private final Random random;

    public Randoms(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Минимум не может быть больше максимума");
        }
        this.min = min;
        this.max = max;
        this.random = new Random();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            // Бесконечный итератор — всегда есть следующий элемент
            return true;
        }

        @Override
        public Integer next() {
            // Возвращает случайное число от min до max включительно
            return random.nextInt(max - min + 1) + min;
        }
    }
}