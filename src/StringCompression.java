import java.util.Scanner;

public class StringCompression {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the string
        String str = sc.nextLine();

        // Edge case: empty string
        if (str.length() == 0) {
            System.out.println("");
            return;
        }

        StringBuilder compressed = new StringBuilder();

        // Iterate through the string
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i - 1));
                compressed.append(count);
                count = 1;
            }
        }

        // Append last character group
        compressed.append(str.charAt(str.length() - 1));
        compressed.append(count);

        // Compare lengths and print result
        if (compressed.length() < str.length()) {
            System.out.println(compressed.toString());
        } else {
            System.out.println(str);
        }

        sc.close();
    }
}
