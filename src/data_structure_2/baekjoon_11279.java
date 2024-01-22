package data_structure_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class baekjoon_11279 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(priorityQueue.isEmpty()){
                    bw.write(0+"\n");
                } else {
                    bw.write(priorityQueue.remove()+"\n");
                }
            } else {
                priorityQueue.add(input);
            }
        }
        bw.close();
    }
}
