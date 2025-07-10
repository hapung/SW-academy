import java.util.Scanner;

class Solution {
    static int[][] map;
    static String[] ans;
    static int N;

    static void rotate() {
        int[][] temp = new int [N][N];
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                temp[j][N-1-i] = map[i][j];
            }

        }
        for (int i=0;i<N;i++) {
            String s = "";
            for (int j=0;j<N;j++) {
                s += temp[i][j];
            }
            ans[i] += s;
            ans[i] += " ";
        }
        map = temp.clone();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1;test_case<=T;test_case++) {
            N = sc.nextInt();
            map = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            ans = new String[N];
            for (int i=0;i<N;i++) {
                ans[i] = "";
            }
            for(int i=0; i<N;i++) {
                rotate();
            }
            System.out.printf("#%d\n", test_case);
            for(int i=0;i<N;i++) {
                System.out.println(ans[i]);
            }
        }

    }
}