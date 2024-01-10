package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_11399 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<N; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);
        int res = 0;
        int N2 = N;
        for(int n : nums){
            res += n*N2;
            N2--;
        }
        System.out.println(res);
    }
}
