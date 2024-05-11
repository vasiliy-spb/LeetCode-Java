package matrix.workingPeoplesImitation.task_786_K_th_Smallest_Prime_Fraction;

import java.util.PriorityQueue;

public class Solution {

    // my solution
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Entity> queue = new PriorityQueue<>((e1, e2) -> Double.compare(e1.value, e2.value));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                queue.offer(new Entity((double) arr[i] / arr[j], arr[i], arr[j]));
            }
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return new int[]{queue.peek().a, queue.peek().b};
    }
    private static class Entity {
        double value;
        int a;
        int b;

        public Entity(double value, int a, int b) {
            this.value = value;
            this.a = a;
            this.b = b;
        }
    }

    // from editorial (Approach 1: Binary Search)
    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        int n = arr.length;
        double left = 0, right = 1.0;

        // Binary search for finding the kth smallest prime fraction
        while (left < right) {
            // Calculate the middle value
            double mid = (left + right) / 2;

            // Initialize variables to keep track of maximum fraction and indices
            double maxFraction = 0.0;
            int totalSmallerFractions = 0, numeratorIdx = 0, denominatorIdx = 0;
            int j = 1;

            // Iterate through the array to find fractions smaller than mid
            for (int i = 0; i < n - 1; i++) {
                while (j < n && arr[i] >= mid * arr[j]) {
                    j++;
                }

                // Count smaller fractions
                totalSmallerFractions += (n - j);

                // If we have exhausted the array, break
                if (j == n) break;

                // Calculate the fraction
                double fraction = (double) arr[i] / arr[j];

                // Update maxFraction and indices if necessary
                if (fraction > maxFraction) {
                    numeratorIdx = i;
                    denominatorIdx = j;
                    maxFraction = fraction;
                }
            }

            // Check if we have found the kth smallest prime fraction
            if (totalSmallerFractions == k) {
                return new int[]{arr[numeratorIdx], arr[denominatorIdx]};
            } else if (totalSmallerFractions > k) {
                right = mid; // Adjust the range for binary search
            } else {
                left = mid; // Adjust the range for binary search
            }
        }
        return new int[]{}; // Return empty array if kth smallest prime fraction not found
    }

    // from editorial (Approach 2: Priority Queue)
    public int[] kthSmallestPrimeFraction3(int[] arr, int k) {
        // Create a priority queue to store pairs of fractions
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Push the fractions formed by dividing each element by
        // the largest element into the priority queue
        for (int i = 0; i < arr.length; i++) {
            pq.offer(new double[] {
                    -1.0 * arr[i] / arr[arr.length - 1],
                    i,
                    arr.length - 1
            });
        }

        // Iteratively remove the top element (smallest fraction)
        // and replace it with the next smallest fraction
        while (--k > 0) {
            double[] cur = pq.poll();
            int numeratorIndex = (int) cur[1];
            int denominatorIndex = (int) cur[2] - 1;
            if (denominatorIndex > numeratorIndex) {
                pq.offer(new double[] {
                        -1.0 * arr[numeratorIndex] / arr[denominatorIndex],
                        numeratorIndex,
                        denominatorIndex
                });
            }
        }

        // Retrieve the kth smallest fraction from
        // the top of the priority queue
        double[] result = pq.poll();
        return new int[]{arr[(int) result[1]], arr[(int) result[2]]};
    }

    // from walkccc.me
    public int[] kthSmallestPrimeFraction4(int[] arr, int k) {
        final int n = arr.length;
        double l = 0.0;
        double r = 1.0;

        while (l < r) {
            final double m = (l + r) / 2.0;
            int fractionsNoGreaterThanM = 0;
            int p = 0;
            int q = 1;

            // For each index i, find the first index j s.t. arr[i] / arr[j] <= m,
            // so fractionsNoGreaterThanM for index i will be n - j.
            for (int i = 0, j = 1; i < n; ++i) {
                while (j < n && arr[i] > m * arr[j])
                    ++j;
                if (j == n)
                    break;
                fractionsNoGreaterThanM += n - j;
                if (p * arr[j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[j];
                }
            }

            if (fractionsNoGreaterThanM == k)
                return new int[] {p, q};
            if (fractionsNoGreaterThanM > k)
                r = m;
            else
                l = m;
        }

        throw new IllegalArgumentException();
    }

}
