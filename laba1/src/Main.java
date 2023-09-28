import java.util.Scanner;
/**
 * Головний клас Main, що починає роботу програми.
 */

public class Main {
    /**
     * Головний метод програми
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many start fibonacci numbers you want to check?");
        int numbers = scanner.nextInt();
        Fibonacci fibonaccinumbers[] = new Fibonacci[numbers];
        CreateArray(fibonaccinumbers, fibonaccinumbers.length);
        CheckForm(fibonaccinumbers, fibonaccinumbers.length);
    }

    /**
     * Метод для створення масиву
     * @param arr - масив
     * @param N - розмірність масиву
     */
    public static void CreateArray(Fibonacci[] arr, int N) {
        arr[0] = new Fibonacci(0, 1);
        arr[1] = new Fibonacci(1,2);
        for(int i = 2; i < N; i++) {
            arr[i] = new Fibonacci(arr[i-2].GetValue() + arr[i-1].GetValue(), i+1);
        }
    }

    /**
     * Метод для перевірки чи числа задовільняють умову
     * @param arr - масив
     * @param N - розмірність масиву
     */
    public static void CheckForm(Fibonacci[] arr, int N) {
        for(int i = 0; i < N; i++) {
            if(arr[i].CheckNumber()) System.out.println("[" + arr[i].GetNumber() +"]Your number: " + arr[i].GetValue() + " can be submitted in the form w^3 + 1");
        }
    }
}

/*11. Визначити, які числа серед перших N чисел Фібоначчі можна задати у формі w^3 + 1  (на 1 більше ніж певний куб).*/
