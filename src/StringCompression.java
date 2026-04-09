import java.util.Scanner;

public class StringCompression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input string
        String S = sc.nextLine();

        // Edge case
        if (S.length() == 0) {
            System.out.println("");
            return;
        }

        StringBuilder compressed = new StringBuilder();

        int count = 1;

        // Traverse string
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(S.charAt(i - 1));
                compressed.append(count);
                count = 1;
            }
        }

        // Add last character group
        compressed.append(S.charAt(S.length() - 1));
        compressed.append(count);

        // Compare lengths
        if (compressed.length() < S.length()) {
            System.out.println(compressed.toString());
        } else {
            System.out.println(S);
        }

        sc.close();
    }
}
