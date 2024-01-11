package divide_and_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2630 {

    public static int[][] nums;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        white_blue(1, 1, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void white_blue(int row, int col, int length){
        if(colorCheck(row, col, length)){
           if(nums[row][col] == 0){
               white++;
           } else {
               blue++;
           }
           return;
        }
        white_blue(row, col, length/2);
        white_blue(row, col+length/2, length/2);
        white_blue(row+length/2, col, length/2);
        white_blue(row+length/2, col+length/2, length/2);
    }

    public static boolean colorCheck(int row, int col, int length){
        int base = nums[row][col];
        for(int i=row; i<row+length; i++){
            for(int j=col; j<col+length; j++){
                if(base != nums[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
