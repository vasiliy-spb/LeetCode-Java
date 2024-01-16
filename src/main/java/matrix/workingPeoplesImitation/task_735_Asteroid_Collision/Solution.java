package matrix.workingPeoplesImitation.task_735_Asteroid_Collision;

import java.util.Stack;

public class Solution {

    // my solution
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int ast = asteroids[i];
            while (!stack.empty() && ast != 0 && Math.signum(stack.peek()) > Math.signum(ast)) {
                    int weight1 = stack.peek();
                    int weight2 = -ast;
                    if (weight1 == weight2) {
                        stack.pop();
                        ast = 0;
                    } else if (weight1 < weight2) {
                        stack.pop();
                    } else {
                        ast = 0;
                    }
            }
            if (ast != 0) stack.push(ast);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    // from walkccc.me
    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (final int a : asteroids)
            if (a > 0) {
                stack.push(a);
            } else { // a < 0
                // Destroy the previous positive one(s).
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a)
                    stack.pop();
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(a);
                else if (stack.peek() == -a)
                    stack.pop(); // Both asteroids explode.
                else           // stack[-1] > the current asteroid.
                    ;            // Destroy the current asteroid, so do nothing.
            }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
