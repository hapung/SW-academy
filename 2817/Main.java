import java.util.*;

class Solution {

    static int N,K, ans, sum;
    static int[] seq;
    static boolean[] visited;

    static void findAns(int num) {

        sum += seq[num];
        if(num == N-1) {
            if(sum == K) ans++;
            sum -= seq[num];
            return;
        }
        if(sum > K) {
            sum -= seq[num];
            findAns(num+1);
        }
        else if(sum < K) {
            visited[num] = true;
            findAns(num+1);

        }
        else {
            sum-= seq[num];
            findAns(num+1);
            ans++;
        }
        if(!visited[num]) return;
        else {
            sum -= seq[num];
            visited[num] = false;
            findAns(num+1);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T;test_case++) {

            N = sc.nextInt();
            K = sc.nextInt();
            seq = new int[N];
            visited = new boolean[N];
            ans = 0;

            for(int i=0;i<N;i++) {
                seq[i] = sc.nextInt();
            }


            findAns(0);
            System.out.printf("#%d %d\n",test_case, ans);

        }
    }
}