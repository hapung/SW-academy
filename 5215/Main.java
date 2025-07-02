import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static class ingredient {
        int point;
        int cal;
        float rate;

        ingredient(int point, int cal) {
            this.point = point;
            this.cal = cal;
            this.rate = (float)point/cal;
        }
    }
    static int N, L, t_point,cost, max_point=0 ;
    static ingredient[] ls;

    public static void dfs(int i) {
        for(int k = i;k<N;k++) {
            if(cost + ls[k].cal>L) {
                continue;
            }
            int temp_p = t_point;
            int temp_c = cost;
            cost += ls[k].cal;
            t_point += ls[k].point;
            if(t_point > max_point) max_point = t_point;
            dfs(k+1);
            t_point = temp_p;
            cost = temp_c;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T;test_case++) {

            N = sc.nextInt();
            L = sc.nextInt();
            ls = new ingredient[N];
            max_point = 0;
            for (int i=0;i<N;i++) {
                int p = sc.nextInt();
                int c = sc.nextInt();
                ingredient ig = new ingredient(p,c);
                ls[i] = ig;
            }

            Arrays.sort(ls, (a,b) -> {
                int cmp = Float.compare(b.rate, a.rate);
                if (cmp != 0) return cmp;
                return Integer.compare(b.cal, a.cal);
            });

            for(int i=0;i<N;i++) {
                t_point = ls[i].point;
                cost = ls[i].cal;
                dfs(i+1);
            }

            System.out.printf("#%d %d\n", test_case, max_point);

        }
    }
}