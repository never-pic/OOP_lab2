import java.util.Scanner;

public class TextApplication {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text:");
            String inputString = scanner.nextLine();

            System.out.println("Enter start character:");
            char startChar = scanner.next().charAt(0);

            System.out.println("Enter end character:");
            char endChar = scanner.next().charAt(0);

            TextProcessor processor = new TextProcessor();
            StringBuilder result = processor.processText(inputString, startChar, endChar);

            System.out.println("Result:");
            System.out.println(result.toString());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}