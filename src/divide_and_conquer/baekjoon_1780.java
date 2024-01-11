package divide_and_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1780 {

    public static int[][] nums;
    public static int minus;
    public static int zero;
    public static int one;

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
        numberOfPaper(1, 1, N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void numberOfPaper(int row, int col, int n){
        int base = nums[row][col];
        if(numberCheck(row, col, n)){
            if(base == -1) minus++;
            else if(base == 0) zero++;
            else one++;
            return;
        }
        int m = n/3;
        numberOfPaper(row, col, m);
        numberOfPaper(row, col+m, m);
        numberOfPaper(row, col+2*m, m);
        numberOfPaper(row+m, col, m);
        numberOfPaper(row+m, col+m, m);
        numberOfPaper(row+m, col+2*m, m);
        numberOfPaper(row+2*m, col, m);
        numberOfPaper(row+2*m, col+m, m);
        numberOfPaper(row+2*m, col+2*m, m);
    }

    public static boolean numberCheck(int row, int col, int n){
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
