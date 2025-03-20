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

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 7, 5};
        int K1 = 12;
        int K2 = 5;
        int K3 = 7;
        int K4 = 11;

        System.out.println(Arrays.toString(sumTarget(A, K1)));
        System.out.println(Arrays.toString(sumTarget(A, K2)));
        System.out.println(Arrays.toString(sumTarget(A, K3)));
        System.out.println(Arrays.toString(sumTarget(A, K4)));
    }
}
