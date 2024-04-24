public class Main {

    public static double f(double x){
        return (Math.pow(x, 5) -2*x+4-(1.4*x)* Math.cos(x)); }

    public static double fStr(double x){
        return (5* Math.pow(x, 4) -2+1.1*Math.sin(x));  }

    /**
     * Головний метод програми
     */
    public static void main(String[] args) {
        System.out.println("Марушкевич Роман Варіант 11");;
        System.out.println("Корінь лежить на проміжку [-1.6; -1.4]");
        System.out.println(LINE);


        System.out.println(" ".repeat(42)+"Метод дихотомії");
        System.out.print("Значення кореня зі вказаною точністю (0.00001): ");
        Dichotomy(0.00001, 0);
        System.out.println("Кількість ітерацій в залежності від зміни точності:");
        System.out.println("Точність:\te^-1\te^-2\te^-3\te^-4\te^-5\te^-6\te^-7\te^-8\te^-9\te^-10");
        System.out.print("Ітерації:\t");
        for(double e=0.01, i=0;i<10;i++, e*=0.1){
            Dichotomy(e, 1);
        }
        System.out.println("\n"+LINE);


        System.out.println(" ".repeat(42)+"Метод хорд");
        System.out.print("Значення кореня зі вказаною точністю (0.00001): ");
        Chord(0.00001, 0);
        System.out.println("Кількість ітерацій в залежності від зміни точності:");
        System.out.println("Точність:\te^-1\te^-2\te^-3\te^-4\te^-5\te^-6\te^-7\te^-8\te^-9\te^-10");
        System.out.print("Ітерації:\t");
        for(double e=0.01, i=0;i<10;i++, e*=0.1){
            Chord(e, 1);
        }
        System.out.println("\n"+LINE);


        System.out.println(" ".repeat(42)+"Метод Ньютона");
        System.out.print("Значення кореня зі вказаною точністю (0.00001): ");
        Newton(0.00001, 0);
        System.out.println("Кількість ітерацій в залежності від зміни точності:");
        System.out.println("Точність:\te^-1\te^-2\te^-3\te^-4\te^-5\te^-6\te^-7\te^-8\te^-9\te^-10");
        System.out.print("Ітерації:\t");
        for(double e=0.01, i=0;i<10;i++, e*=0.1){
            Newton(e, 1);
        }
        System.out.println("\n"+LINE);

        System.out.println(" ".repeat(42)+"Метод простої ітерації");
        System.out.println("Похідна: F'(x) = 0.55 * sin(x) + 2.5 * x^4");
        System.out.println("F1'(x) = 15.834");
        System.out.println("F2'(x) = 9.062");
        System.out.println("F1'(x) i F2'(x) повинні бути < 1");
        System.out.print("Корінь не можливо знайти ітераційним методом.");
        System.out.println("\n"+LINE);
    }

    /**
     * Виведення інформації про автора програми
     */
    private static final String LINE = "-".repeat(100);


    /**
     * Метод дихотомії
     */
    private static void Dichotomy(double precision, int flag){
        double a = -1.6, b = -1.4, xr = (a+b)/2;  // межі проміжку
        int counter = 0;

        while(Math.abs(b-a) > precision) {  // уточнюємо значення кореня
            if(f(a) * f(xr) < 0)
                b = xr;
            else
                a = xr;
            xr = (a+b)/2;
            counter++;
        }
        if (flag == 0){     // виводимо результати
            System.out.print(xr + "\n");
            System.out.println("Кількість ітерацій: " + counter);
        }
        else{
            System.out.print(counter + "\t\t");
        }
    }

    /**
     * Метод хорд
     */
    private static void Chord(double precision, int flag){
        double a = -1.6, b = -1.4, xr;  // межі проміжку
        double xz, r;
        int counter = 0;

        if(f(a) > 0)    // уточнюємо значення кореня
            xz = b;
        else
            xz = a;
        do{
            if(f(a) > 0){
                xr = xz - (f(xz) / (f(xz)-f(a))) * (xz-a);
            }
            else{
                xr = xz - (f(xz) / (f(xz)-f(b))) * (xz-b);
            }
            r = Math.abs(xz-xr);
            xz = xr;
            counter++;
        } while(r > precision);

        if (flag == 0){     // виводимо результати
            System.out.print(xr + "\n");
            System.out.println("Кількість ітерацій: " + counter);
        }
        else{
            System.out.print(counter + "\t\t");
        }
    }

    /**
     * Метод Ньютона
     */
    private static void Newton(double precision, int flag){
        double a = -1.6, b = -1.4, xr;  // межі проміжку
        double xz, r;
        int counter = 0;

        if(f(a)*fStr(a) > 0)    //уточнюємо значення кореня
            xz = a;
        else
            xz = b;
        do{
            xr = xz - f(xz)/fStr(xz);
            r = Math.abs(xz-xr);
            xz = xr;
            counter++;
        } while(r > precision);

        if (flag == 0){     // виводимо результати
            System.out.print(xr + "\n");
            System.out.println("Кількість ітерацій: " + counter);
        }
        else{
            System.out.print(counter + "\t\t");
        }
    }


}
