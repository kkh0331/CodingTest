package data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_10799 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");
        int stack = 0;
        int count = 0;
        for(int i=0; i<inputs.length; i++){
            if(inputs[i].equals("(")){
                stack++;
            }else{
                stack--;
                if(inputs[i-1].equals("(")){
                    count += stack;
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
