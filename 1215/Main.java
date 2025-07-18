import java.util.*;

class Solution {
    static int N, ans;
    static char[][] map = new char[8][8];

    static void swap()  {
        for(int i=0;i<8;i++) {
            for(int j=i+1;j<8;j++) {
                char t = map[i][j];
                map[i][j] = map[j][i];
                map[j][i] = t;
            }
        }
    }

    static void checkMap(int dir) {

        if(dir == 1) swap();

        for(int i=0 ;i<8;i++) {
            for(int j=0;j<=8-N;j++) {
                char[] c = new char[N];
                for(int k = 0;k<N;k++) {
                    c[k] = map[i][j+k];
                }
                int res = 0;
                for(int k=0;k<N/2;k++) {
                    if(c[k] != c[N-k-1]){
                        res = 1;
                        break;
                    }
                }
                if (res == 0) {
                    ans++;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int test_case = 1; test_case<=T;test_case++) {
            N = sc.nextInt();
            ans = 0;

            for(int i=0;i<8;i++) {
                map[i] = sc.next().toCharArray();
            }

            for(int i=0;i<2;i++) {
                checkMap(i);
            }
            System.out.printf("#%d %d\n", test_case, ans);
        }
    }
}