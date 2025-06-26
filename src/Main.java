public class Main {
    public static void main(String[] args) {
        int[] original = {12, 5, 18, 7, 19, 8, 10};
        int n = original.length;
        int[] V = new int[n + 2];
        for (int i = 0; i < n; i++) {
            V[i + 1] = original[i];
        }
        V[n + 1] = 9999;

        int result = longestIncreasingSubsequence(V, n + 1);
        System.out.println("Longest increasing subsequence length: " + result);
        System.out.println("Total Cost :O(N^2)");
    }

    public static int longestIncreasingSubsequence(int[] V, int end) {
        int[] T = new int[V.length];
        for (int m = 1; m <= end; m++) {
            T[m] = 1;
            for (int k = 1; k < m; k++) {
                if (V[k] < V[m]) {
                    T[m] = Math.max(T[m], T[k] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i < end; i++) {
            max = Math.max(max, T[i]);
        }

        return max;
    }
}
