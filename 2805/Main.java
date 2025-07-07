import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1;test_case<=T;test_case++) {
            int N = sc.nextInt();

            int res = 0;
            int[][] farm = new int[N][N];
            for(int i=0;i<N;i++) {
                String s = sc.next();
                for (int j=0;j<N;j++) {
                    farm[i][j] = s.charAt(j) - '0';
                }
            }

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    int a = farm[i][j];
                    int x = i+j;
                    int y = i-j;
                    if(x<=(3*(N-1))/2 && x>=(N-1)/2 && y>=-(N-1)/2 && y<=(N-1)/2) res+=a;
                }
            }
            System.out.printf("#%d %d\n", test_case, res);


        }
    }
}