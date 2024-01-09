package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> meeting = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_time = Integer.parseInt(st.nextToken());
            int end_time = Integer.parseInt(st.nextToken());
            meeting.add(new Node(start_time, end_time));
        }
        Collections.sort(meeting, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                if(n1.end_time == n2.end_time){
                    return n1.start_time - n2.end_time;
                }
                return n1.end_time - n2.end_time;
            }
        });
        Node node = meeting.get(0);
        int count = 1;
        for(int i=1; i<N; i++){
            if(node.end_time <= meeting.get(i).start_time){
                node = meeting.get(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static class Node {
        int start_time;
        int end_time;

        public Node(int start_time, int end_time){
            this.start_time = start_time;
            this.end_time = end_time;
        }
    }
}
