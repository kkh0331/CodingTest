package dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_9184 {

    public static int[][][] arr = new int[21][21][21];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1) break;
            bw.write("w("+a+", "+b+", "+c+") = "+recursion(a,b,c)+"\n");
        }
        bw.close();
    }

    public static int recursion(int a, int b, int c){
        if(a<=0 || b<=0 || c<=0){
            return 1;
        } else if(a>20 || b>20 || c>20){
            arr[20][20][20] = arr[20][20][20] == 0 ? recursion(20,20,20) : arr[20][20][20];
            return arr[20][20][20];
        } else if(a<b && b<c){
            arr[a][b][c-1] = arr[a][b][c-1] == 0 ? recursion(a,b,c-1) : arr[a][b][c-1];
            arr[a][b-1][c-1] = arr[a][b-1][c-1] == 0 ? recursion(a, b-1, c-1) : arr[a][b-1][c-1];
            arr[a][b-1][c] = arr[a][b-1][c] == 0 ? recursion(a,b-1,c) : arr[a][b-1][c];
            return arr[a][b][c-1] + arr[a][b-1][c-1] - arr[a][b-1][c];
        } else {
            arr[a - 1][b][c] = arr[a - 1][b][c] == 0 ? recursion(a - 1, b, c) : arr[a - 1][b][c];
            arr[a - 1][b - 1][c] = arr[a - 1][b - 1][c] == 0 ? recursion(a - 1, b - 1, c) : arr[a - 1][b - 1][c];
            arr[a - 1][b][c - 1] = arr[a - 1][b][c - 1] == 0 ? recursion(a - 1, b, c - 1) : arr[a - 1][b][c - 1];
            arr[a - 1][b - 1][c - 1] = arr[a - 1][b - 1][c - 1] == 0 ? recursion(a - 1, b - 1, c - 1) : arr[a - 1][b - 1][c - 1];
            return arr[a - 1][b][c] + arr[a - 1][b - 1][c] + arr[a - 1][b][c - 1] - arr[a - 1][b - 1][c - 1];
        }
    }
}
