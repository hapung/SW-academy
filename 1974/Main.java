import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1;test_case<=T;test_case++) {
            int[][] map = new int[9][9];

            int ans = 1;
            for(int i=0;i<9;i++) {
                for(int j=0;j<9;j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i=0;i<9;i++) {
                int[] check = new int[10];
                for(int j=0;j<9;j++) {
                    int k = map[i][j];
                    if(check[k] == 1) {
                        ans = 0;
                        break;
                    }
                    check[k] = 1;
                }
                if(ans == 0) break;
            }

            for(int i=0;i<9;i++) {
                int[] check = new int[10];
                for(int j=0;j<9;j++) {
                    int k = map[j][i];
                    if (check[k] == 1) {
                        ans = 0; break;
                    }
                    check[k] = 1;
                }
                if (ans == 0) break;
            }
            for (int blockRow = 0; blockRow < 9; blockRow += 3) {
                for (int blockCol = 0; blockCol < 9; blockCol += 3) {
                    int[] check = new int[10]; // 1~9 확인용
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            int num = map[blockRow + i][blockCol + j];
                            if (check[num] == 1) {
                                ans = 0;
                                break;
                            }
                            check[num] = 1;
                        }
                        if (ans == 0) break;
                    }
                    if (ans == 0) break;
                }
                if (ans == 0) break;
            }

            System.out.printf("#%d %d\n", test_case, ans);


        }
    }
}