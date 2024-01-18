package data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1158 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        bw.write("<");
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            for(int i=0; i<K-1; i++){
                queue.add(queue.remove());
            }
            bw.write(queue.remove()+"");
            if(!queue.isEmpty()){
                bw.write(", ");
            }
        }
        bw.write(">");
        bw.close();;
    }
}
