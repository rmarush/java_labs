import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = CreateCustomersList(scanner);
        SearchByName(customers, scanner);
        SearchInRange(customers, scanner);
        SearchDebtors(customers);
    }
    public static List<Customer> CreateCustomersList(Scanner scanner) {
        List<Customer> customers = new ArrayList<>();
        boolean i = true;
        while(i) {
            Customer customer = new Customer();
            System.out.printf("Enter a surname: ");
            customer.SetSurname(scanner.nextLine());
            System.out.printf("Enter a name: ");
            customer.SetName(scanner.nextLine());
            System.out.printf("Enter a second name: ");
            customer.SetSecondName(scanner.nextLine());
            System.out.printf("Enter an adress: ");
            customer.SetAdress(scanner.nextLine());
            System.out.printf("Enter a card number: ");
            customer.SetCardNumber(scanner.nextLong());
            System.out.printf("Enter a balance: ");
            customer.SetBalance(scanner.nextLong());
            scanner.nextLine();
            customers.add(customer);
            i = ContinueOrStop(scanner);
        }
        return customers;
    }
    public static boolean ContinueOrStop(Scanner scanner) {
        while (true) {
            System.out.println("Do you want to continue entering data [Yes/No]?");
            String decision = scanner.nextLine();
            if (decision.equals("Yes")) {
                return true;
            } else if (decision.equals("No")) {
                System.out.println("Data entry is complete");
                return false;
            }
        }

    }
    public static void SearchByName(List<Customer> customers, Scanner scanner) {
        int count = 0;
        System.out.printf("Enter name for search: ");
        String searchName = scanner.nextLine();
        for(Customer customer : customers) {
            if(customer.GetName().equals(searchName)) {
                System.out.println("\nInformation about customer #" + (count + 1) + "with name " + searchName);
                System.out.println(customer);
                count++;
            }
        }
        if(count == 0) {
            System.out.println("There is no client with this name in the list" + searchName);
        }
    }
    public static void SearchInRange(List<Customer> customers, Scanner scanner) {
        long startRange, endRange;
        int count = 0;
        System.out.printf("Enter start range: ");
        startRange = scanner.nextLong();
        System.out.printf("Enter end range: ");
        endRange = scanner.nextLong();
        for(Customer customer: customers) {
            long cardNumber = customer.GetCardNumber();
            if(cardNumber > startRange && cardNumber < endRange) {
                System.out.println("\nInformation about customer #" + (count + 1) + " in your range:");
                System.out.println(customer);
                count++;
            }
        }
        if(count == 0) {
            System.out.println("There are no clients listed in the range");
        }
    }
    public static void SearchDebtors(List<Customer> customers) {
        int count = 0;
        for(Customer customer : customers) {
            if(customer.GetBalance() < 0) {
                System.out.println("\nInformation about #" + (count + 1) + " debtors:");
                System.out.println(customer);
                count++;
            }
        }
        if(count == 0) {
            System.out.println("There are no debtors in the list");
        }
    }
}