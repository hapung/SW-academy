import java.util.Scanner;

class Solution {
    static int N, cnt;
    static boolean[] col, dia1, dia2;

    static void dfs(int r) {
        if (r==N) {
            cnt++;
            return;
        }

        for(int c = 0;c<N;c++) {
            if(col[c] || dia1[r+c] || dia2[r-c+N-1]) continue;

            col[c] = dia1[r+c] = dia2[r-c+N-1] = true;
            dfs(r+1);
            col[c] = dia1[r+c] = dia2[r-c+N-1] = false;
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case=1;test_case <=T;test_case++) {
            N = sc.nextInt();
            cnt = 0;
            col = new boolean[N];
            dia1 = new boolean[2*N - 1];
            dia2 = new boolean[2*N - 1];

            dfs(0);
            System.out.printf("#%d %d\n", test_case, cnt);
        }
    }
}