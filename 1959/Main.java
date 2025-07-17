import java.util.*;

class Solution {
    static int N,M,K,L, max;
    static int[]A,B;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1;test_case<=T;test_case++) {

            N = sc.nextInt();
            M = sc.nextInt();

            K = Math.max(N,M);
            L = Math.min(N,M);
            A = new int[K];
            B = new int[L];

            if (N>M) {
                for(int i=0;i<K;i++) {
                    A[i] = sc.nextInt();
                }
                for(int i=0;i<L;i++) {
                    B[i] = sc.nextInt();
                }
            }
            else {
                for(int i=0;i<L;i++) {
                    B[i] = sc.nextInt();
                }
                for(int i=0;i<K;i++) {
                    A[i] = sc.nextInt();
                }
            }

            max = 0;

            for(int i=0;i<=Math.abs(M-N);i++) {
                int temp = 0;
                for(int j=0;j<L;j++) {
                    temp += A[j+i] * B[j];

                }
                max = Math.max(max, temp);
            }


            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}