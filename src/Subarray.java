import java.util.Arrays;

public class Subarray {
    public static int[] sumTarget(int[] A, int K) {
        int start = 0;
        int currentSum = 0;

        for (int i = 0; i < A.length; i++) {
            currentSum += A[i];

            while (currentSum > K && start <= i) {
                currentSum -= A[start];
                start++;
            }

            if (currentSum == K) {
                return new int[] {start, i};
            }
        }
        return new int[] {-1, -1};
    }
}
