import java.util.Scanner;

class Solution {
    static int N, K;
    static int[][] puzzle;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1;test_case<=T;test_case++) {

            N = sc.nextInt();
            K = sc.nextInt();

            puzzle = new int[N][N];
            int res = 0;
            for(int i=0;i<N;i++) {
                int cnt = 0;
                for(int j=0;j<N;j++) {
                    int b = sc.nextInt();
                    puzzle[i][j] = b;
                    if(b==1) {
                        cnt++;
                        if(j==N-1 && cnt == K) {
                            res++;
                            cnt = 0;
                        }
                    }
                    else {
                        if(cnt == K) {
                            res++;
                            cnt = 0;
                        }
                        else cnt = 0;

                    }

                }

            }
            for(int i=0;i<N;i++) {
                int cnt = 0 ;
                for(int j=0;j<N;j++) {
                    int b = puzzle[j][i];
                    if(b==1) {
                        cnt++;
                        if(j==N-1 && cnt == K) {
                            res++;
                            cnt = 0;
                        }
                    }
                    else {
                        if(cnt == K) {
                            res++;
                            cnt = 0;
                        }
                        else cnt = 0;
                    }

                }
            }

            System.out.printf("#%d %d\n", test_case, res);

        }
    }
}