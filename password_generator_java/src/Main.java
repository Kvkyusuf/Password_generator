import java.util.Scanner;

class PasswordGenerator {
    private final int length;

    PasswordGenerator(int length) {
        this.length = length;
    }

    public String generate() {
        StringBuilder password = new StringBuilder();

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+-*/_?=)(/&%+'^|][{<>|";

        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Password generator");

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter password length: ");
                int length = scanner.nextInt();

                if (length < 8) {
                    System.out.println("Lenght must be bigger than 8");
                    System.out.println("\n-----------------------------------------------\n");
                    continue;
                }

                PasswordGenerator passwordGenerator = new PasswordGenerator(length);
                String password = passwordGenerator.generate();

                System.out.println("Generated password: " + password);
            } catch (Exception e) {
                System.out.println("Invalid input");
            }

            System.out.println("\n-----------------------------------------------\n");
        }
    }
}