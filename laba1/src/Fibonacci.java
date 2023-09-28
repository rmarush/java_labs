/**
 * Клас для визначення чисел Фібоначчі.
 */

public class Fibonacci {
    private int value;
    private int number;
    /**
     * Конструктор класу Fibonacci.
     * @param n кількість чисел, яку потрібно обчислити
     */

    public Fibonacci(int value, int number) {
        this.value = value;
        this.number = number;
    }

    /**
     * Геттер для аргумента value
     * @return value
     */
    public int GetValue() { return value; }
    /**
     * Геттер для аргумента number
     * @return number
     */
    public int GetNumber() { return number; }

    /**
     * Перевіряє чи число задовільняє наш вираз
     * @return true/false
     */
    public boolean CheckNumber() {
        double w = Math.cbrt(value - 1);
        return (Math.pow(w, 3) + 1) == value;
    }
}
