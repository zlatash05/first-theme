import java.util.Stack;
import java.util.Scanner;

public class CorrectStapleFit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine().replaceAll("\\s", "");
        System.out.println(isBalanced(sequence) ? "yes" : "no");
    }

    public static boolean isBalanced(String sequence) {
        Stack<Character> stack = new Stack<>();
        for (char ch : sequence.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
