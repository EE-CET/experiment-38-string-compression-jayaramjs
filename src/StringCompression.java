import java.util.*;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(S.charAt(i - 1));
                compressed.append(count);
                count = 1;
            }
        }

        // Handle last character group
        if (S.length() > 0) {
            compressed.append(S.charAt(S.length() - 1));
            compressed.append(count);
        }

        // Strict condition
        if (compressed.length() < S.length()) {
            System.out.print(compressed.toString());
        } else {
            System.out.print(S);
        }
    }
}
