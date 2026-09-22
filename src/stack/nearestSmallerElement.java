//Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.More formally, G[i] for an element A[i] = an element A[j] such that j is maximum possible AND j < i AND A[j] < A[i]. Elements for which no smaller element exist, consider the next smaller element as -1.

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public static class nearestSmallerElement {

    public int[] prevSmaller(int[] A){
        int n = A.length;
        int[] G = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<n;i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                G[i] = -1;
            } else {
                G[i] = stack.peek();
            }

            stack.push(A[i]);
        }
        return G;
    }
}

public static void main(String[] args) {
    nearestSmallerElement solver = new nearestSmallerElement();

    // Example 1:
    // A = [4, 5, 2, 10, 8]
    // Expected: [-1, 4, -1, 2, 2]
    int[] A1 = {4, 5, 2, 10, 8};
    System.out.println("Input:  " + Arrays.toString(A1));
    System.out.println("Output: " + Arrays.toString(solver.prevSmaller(A1)));

    // Example 2:
    // A = [3, 2, 1]
    // Expected: [-1, -1, -1]
    int[] A2 = {3, 2, 1};
    System.out.println("\nInput:  " + Arrays.toString(A2));
    System.out.println("Output: " + Arrays.toString(solver.prevSmaller(A2)));
}
