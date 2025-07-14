import java.sql.SQLOutput;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1;test_case<=T;test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            Map<Integer, Double> Score = new HashMap<>();
            for(int i=1;i<=N;i++) {
                Double avg = 0.0;
                avg += 0.35 * sc.nextDouble();
                avg += 0.45 * sc.nextDouble();
                avg += 0.2 * sc.nextDouble();
                Score.put(i, avg);
            }
            List<Integer> keySet = new ArrayList<>(Score.keySet());
            keySet.sort((o1,o2) -> Score.get(o2).compareTo(Score.get(o1)));
            String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D"};
            double rank = keySet.indexOf(K) + 1;
            int t = (int)(Math.ceil((rank/N) * 10));
            System.out.printf("#%d %s", test_case, grade[t-1]);


        }
    }
}