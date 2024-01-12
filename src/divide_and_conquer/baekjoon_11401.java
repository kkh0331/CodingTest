package divide_and_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11401 {

    /*
    페르마의 소정리
    p가 소수이고 a가 정수일 때, 아래
    a^p mod p = a mod p
    a^(p-2) mod p = 1/a mod p

    -> 이항 계수 : N(N-1)~~(N-K+1)((K!)^(p-2)) % p
    */

    public static final int divider = 1_000_000_007; // 소수

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long res = 1;
        for(int i=N-K+1; i<=N; i++){
            res = (res * i) % divider;
        }
        long a = 1; // k!
        for(int i=1; i<=K; i++){
            a = (a * i) % divider;
        }
        int p = divider - 2;
        while(p != 1){
            if(p % 2 == 1){
                res = (res * a) % divider;
            }
            p = p/2;
            a = (a * a) % divider;
        }
        res = (res * a) % divider;
        System.out.println(res);
    }
}
