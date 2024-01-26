package data_structure_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_2696 {

    public static PriorityQueue<Integer> leftQueue; // 홀수 일때, left.size() = right.size() + 1
    public static PriorityQueue<Integer> rightQueue;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            leftQueue = new PriorityQueue<>(Collections.reverseOrder());
            rightQueue = new PriorityQueue<>();
            bw.write((M+1)/2 + "\n");
            for(int m=1; m<=M; m++){
                if(m % 10 == 1) st = new StringTokenizer(br.readLine());
                int input = Integer.parseInt(st.nextToken());
                inputsAdd(input);
                if(m % 20 == 0) bw.write("\n");
            }
            bw.write("\n");
        }
        bw.close();
    }

    public static void inputsAdd(int input) throws Exception {
        int size = leftQueue.size() + rightQueue.size();
        if(size == 0){
            leftQueue.offer(input);
            bw.write(input+" ");
        } else if(size == 1){
            leftQueue.offer(input);
            rightQueue.offer(leftQueue.remove());
        } else if(size % 2 == 0){ //짝수일 경우 추가
            int left = leftQueue.peek();
            int right = rightQueue.peek();
            if(left <= input && input <= right){
                leftQueue.offer(input);
            } else if(input < left){
                leftQueue.offer(input);
            } else if(right < input){
                leftQueue.offer(rightQueue.remove());
                rightQueue.offer(input);
            }
            bw.write(leftQueue.peek()+" ");
        } else { // 홀수일 경우 추가
            int left = leftQueue.peek();
            int right = rightQueue.peek();
            if(left <= input && input <= right){
                rightQueue.offer(input);
            } else if(input < left){
                rightQueue.offer(leftQueue.remove());
                leftQueue.offer(input);
            } else if(right < input){
                rightQueue.offer(input);
            }
        }
    }
}
