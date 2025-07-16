import java.util.*;

class Solution {
    static int c, max;
    static char[] price;
    static Set<String>[] visited;


    static void swap(int i, int j) {
        char temp = price[i];
        price[i] = price[j];
        price[j] = temp;
    }

    static void rotate(int depth) {

        if (depth == c) {
            max = Math.max(max, Integer.parseInt(new String(price)));
            return;
        }

        String current = new String(price);
        if(visited[depth].contains(current)) return;
        visited[depth].add(current);

        for (int i = 0; i < price.length - 1; i++) {
            for (int j = i + 1; j < price.length; j++) {
                swap(i, j);
                rotate(depth + 1);
                swap(i, j);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1;test_case<=T;test_case++) {
            price = sc.next().toCharArray();
            c = sc.nextInt();

            max = 0;

            visited = new HashSet[c + 1];
            for (int i = 0; i <= c; i++) {
                visited[i] = new HashSet<>();
            }

            rotate(0);

            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}