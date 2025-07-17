import java.util.*;

class Solution {

    static int N;
    static List<int[]> map;

    static void combination(int depth) {
        for(int i=0;i<depth;i++) {
            if(i==0 || i== depth-1 ) {
                map.get(depth-1)[i] = 1;
            }
            else {
                map.get(depth-1)[i] = map.get(depth-2)[i] + map.get(depth-2)[i-1];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1;test_case<=T;test_case++) {

            N = sc.nextInt();

            map = new ArrayList<>();

            map.add(new int[]{1});
            map.add(new int[]{1,1});

            for (int i=3;i<=N;i++) {
                map.add(new int[i]);
            }
            for(int i=3;i<=N;i++) {
                combination(i);
            }


            System.out.printf("#%d\n", test_case);
            for(int i=0;i<N;i++) {
                for(int j=0;j<i+1;j++) {
                    System.out.printf("%d ", map.get(i)[j]);
                }
                System.out.println();
            }

        }
    }
}