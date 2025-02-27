import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMWithdrawal {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000; // Assume starting balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();
            
            if (enteredPin != CORRECT_PIN) {
                throw new InvalidPINException("Error: Invalid PIN entered.");
            }
            
            System.out.print("Withdraw Amount: ");
            double withdrawAmount = scanner.nextDouble();
            
            if (withdrawAmount > balance) {
                throw new InsufficientBalanceException("Error: Insufficient balance.");
            }
            
            balance -= withdrawAmount;
            System.out.println("Withdrawal Successful! Remaining Balance: " + balance);
        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please enter valid details.");
        } finally {
            System.out.println("Current Balance: " + balance);
            scanner.close();
        }
    }
}
