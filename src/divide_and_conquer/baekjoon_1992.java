package divide_and_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_1992 {

    public static int[][] nums;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            String[] numbers = br.readLine().split("");
            for(int j=1; j<=N; j++){
                nums[i][j] = Integer.parseInt(numbers[j-1]);
            }
        }
        quadTree(1,1,N);
        System.out.println(sb);
    }

    public static void quadTree(int row, int col, int n){
        if(colorCheck(row, col, n)){
            if(nums[row][col] == 1){
                sb.append(1);
            } else {
                sb.append(0);
            }
            return;
        }
        sb.append("(");
        quadTree(row, col, n/2);
        quadTree(row, col+n/2, n/2);
        quadTree(row+n/2, col, n/2);
        quadTree(row+n/2, col+n/2, n/2);
        sb.append(")");
    }

    public static boolean colorCheck(int row, int col, int n){
        int base = nums[row][col];
        for(int i=row; i<row+n; i++){
            for(int j=col; j<col+n; j++){
                if(base != nums[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
