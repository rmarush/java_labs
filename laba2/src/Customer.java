public class Customer {
    private String surname;
    private String name;
    private String secondName;
    private String adress;
    private long cardNumber;
    private long balance;
    public Customer() {
    }
    public  Customer(String surname, String name, String secondName, String adress, long cardNumber, long balance) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.adress = adress;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }
    public String GetSurname() {
        return surname;
    }
    public String GetName() {
        return name;
    }
    public  String GetSecondName() {
        return secondName;
    }
    public String GetAdress() {
        return  adress;
    }
    public long GetCardNumber() {
        return cardNumber;
    }
    public long GetBalance() {
        return balance;
    }
    public void SetSurname(String surname) {
        this.surname = surname;
    }
    public void SetName(String name) {
        this.name = name;
    }
    public void SetSecondName(String secondName) {
        this.secondName = secondName;
    }
    public void SetAdress(String adress) {
        this.adress = adress;
    }
    public  void SetCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void SetBalance(long balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Cutomer name: " + surname + " "+ name + " "+ secondName + "\n" + "Custromer adress: " + adress + "\n" + "Card number: " + cardNumber + "\n" + "Balance: " + balance;
    }
}