package divide_and_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_1629 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        List<Long> remainders = new ArrayList<>();
        while(B != 1){
            if(B % 2 == 1){
                remainders.add(A);
            }
            A = (A%C) * (A%C) % C;
            B /= 2;
        }
        long res = A%C;
        for(long n : remainders){
            res = (res%C) * (n%C) % C;
        }
        System.out.println(res);
    }
}
