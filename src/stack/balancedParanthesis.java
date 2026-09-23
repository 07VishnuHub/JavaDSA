//Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

package stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class balancedParanthesis {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false; // no matching opening bracket

                char top = stack.peek();
                if ((c == ')' && top == '(') ||
                        (c == ']' && top == '[') ||
                        (c == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false; // mismatch
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        balancedParanthesis solver = new balancedParanthesis();

        String[] testCases = {
                "()[]{}",      // true
                "([{}])",      // true
                "(]",          // false
                "([)]",        // false
                "{[]}",        // true
                "]",           // false
                "((("          // false
        };

        for (String test : testCases) {
            System.out.printf("Expression: %-8s -> Valid: %b%n", test, solver.isValid(test));
        }
    }
}
