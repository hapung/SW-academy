import java.util.*;

class Solution {
    static int N;
    static int[][] map;
    static int cnt;

    static void magnet(int k) {
        String s = "";
        for(int i = 0;i<N;i++) {
            if(map[i][k] == 0) continue;

            s += map[i][k];
        }

        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i) == '1' && s.charAt(i+1) == '2') cnt++;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int test_case = 1; test_case<=T;test_case++) {
            cnt = 0;
            N = sc.nextInt();
            map = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i=0;i<N;i++) {
                magnet(i);
            }
            System.out.printf("#%d %d\n", test_case, cnt);
        }
    }
}