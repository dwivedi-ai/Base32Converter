import java.util.Scanner;
public class Base32Converter {
    private static final char[] BASE_32_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'};

    public static String decimalToBase32(int num) {
        StringBuilder code = new StringBuilder();
        do {
            int mod32 = num % 32;
            code.insert(0, BASE_32_CHARS[mod32]);
            num /= 32;
        } while (num != 0);
        return code.toString();
    }

    public static int base32ToDecimal(String code) {
        int num = 0;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            int charIndex = indexOf(BASE_32_CHARS, c);
            if (charIndex == -1) {
                throw new IllegalArgumentException("Invalid base-32 code: " + code);
            }
            num = num * 32 + charIndex;
        }
        return num;
    }

    private static int indexOf(char[] array, char c) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Convert decimal to base-32.");
        System.out.println("2. Convert base-32 to decimal.");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number: ");
                int decimalNum = sc.nextInt();
                System.out.println("Base-32 code: " + decimalToBase32(decimalNum));
                break;
            case 2:
                System.out.print("Enter a code: ");
                String base32Code = sc.next();
                System.out.println("Decimal number: " + base32ToDecimal(base32Code));
                break;
            default:
                System.out.println("Invalid choice.");
        }
        sc.close();
    }
}
