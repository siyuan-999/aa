import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystem {
    String Bankchoice;
    static Scanner input = new Scanner(System.in);
    static int userChoice = 0;
    static ArrayList<String> choiceList = new ArrayList<>();
    public static void printBankSystemChoice(){
        System.out.println("Welcome to ICBC , the following is our business ");
        for (int i = 0 ; i < choiceList.size();i ++ ){
            System.out.println(choiceList.get(i));
        }
    }
    public void printchoice(){
        System.out.print(Bankchoice);

    }

    private BankSystem(String choice){
        Bankchoice = choice;
    }
   public static int printuserChoice() {
       while(true){
           try {
               userChoice = input.nextInt();
           } catch (InputMismatchException ex) {
               System.out.println("Try again. (Incorrect input : an integer is required)");
               input.nextLine();
               System.out.println("Enter your choice : ");
               continue;
           }
           if (userChoice > choiceList.size() && userChoice > 0) {
               System.out.println("userChoice value must be : 1 <= userChoice <= 5");
               System.out.println("Enter your choice : ");
               continue;
           }
           if (userChoice <= 5 && userChoice > 0){
               break;
           }
           return userChoice;


       }
       return userChoice;
   }
   public static void printuserChoiceNext(){
        if (userChoice == 1) {
            System.out.println("Please Fill ur personal information carefully");
            while (true) {
                System.out.print("Enter Your Account id: ");
                try {
                    int userAccount = input.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Try again. (Incorrect input your account id : an integer is required)");
                    input.nextLine();
                    continue;
                }
                input.nextLine();
                System.out.print("Enter your FullName: Account type (personal or company): ");
                String userFullName;
                userFullName = input.nextLine().toString();
                System.out.print("Enter Birthday: ");
                try {
                    int userBirthday = input.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Try again. (Incorrect input Birthday : an integer is required)");
                    input.nextLine();
                    continue;
                }
                System.out.print("Enter Password: ");
                try {
                    int userPassword = input.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Try again. (Incorrect input Password : an integer is required)");
                    input.nextLine();

                    continue;
                }
                System.out.print("Enter Your Balance: ");
                try {
                    double userBalance = input.nextDouble();
                } catch (InputMismatchException ex) {
                    System.out.println("Try again. (Incorrect input your balance : an double is required)");
                    input.nextLine();
                    continue;
                }
                input.nextLine();
                System.out.print("Information completed ? (yes/no) : ");
                String userInformation = input.nextLine().toLowerCase();
                if (userInformation.equals("yes")) {
                    break;
                }
            }
        }


   }





    public static void main(String[] arg) {
        BankSystem choice = new BankSystem("Enter your choice : ");
        choiceList.add("1. Create anew account");
        choiceList.add("2. Display all accountdetails");
        choiceList.add("3. Deposit the amount");
        choiceList.add("4. Withdraw the amount");
        choiceList.add("5. other servicess");
        printBankSystemChoice();
        choice.printchoice();
        printuserChoice();
        printuserChoiceNext();
        printBankSystemChoice();


    }
}

