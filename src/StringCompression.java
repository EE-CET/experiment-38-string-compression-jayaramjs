import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Check if input exists
        if (!scanner.hasNextLine()) {
            return;
        }
        
        String s = scanner.nextLine();
        System.out.println(compress(s));
        
        scanner.close();
    }

    public static String compress(String str) {
        // Edge case: if string is empty or length 1, compression won't help
        if (str == null || str.length() <= 1) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If next character is different or we are at the end of the string
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                
                // Optimization: If at any point compressed is longer than original, 
                // we could stop, but for simplicity, we check at the end.
                countConsecutive = 0;
            }
        }

        String result = compressed.toString();

        // Constraint: Return original if compressed is not smaller
        return result.length() < str.length() ? result : str;
    }
}
