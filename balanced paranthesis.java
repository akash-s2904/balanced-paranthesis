import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(); // input string
        char[] stack = new char[a.length()]; // character stack
        int top = -1;

        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack[++top] = ch; // push to stack
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (top == -1) {
                    System.out.println("Not balanced");
                    return;
                }

                char last = stack[top--]; // pop from stack

                if ((ch == ')' && last != '(') ||
                    (ch == ']' && last != '[') ||
                    (ch == '}' && last != '{')) {
                    System.out.println("Not balanced");
                    return;
                }
            }
        }

        // If stack is empty, all brackets matched
        if (top == -1) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }
    }
}
