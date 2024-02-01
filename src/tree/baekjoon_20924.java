package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_20924 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rootGigaLength = 0;
        int gigaLeafLength = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드의 개수
        int R = Integer.parseInt(st.nextToken()); // 루트 노드 번호
        List<Map<Integer, Integer>> nodes = new ArrayList<>();
        for(int i=0; i<=N; i++){
            nodes.add(new HashMap<>());
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes.get(a).put(b, d);
            nodes.get(b).put(a, d);
        }
        int[] saveLength = new int[N+1]; //길이 저장
        boolean[] visited = new boolean[N+1];
        boolean changeMode = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);
        visited[R] = true;
        while(!queue.isEmpty()){
            int removeNode = queue.remove();
            int leafCount = 0;
            for(int connNode : nodes.get(removeNode).keySet()){
                if(!visited[connNode]){
                    leafCount++;
                    visited[connNode] = true;
                    queue.offer(connNode);
                    saveLength[connNode] = saveLength[removeNode] + nodes.get(removeNode).get(connNode);
                }
            }
            if(leafCount > 1 && !changeMode){
                rootGigaLength = saveLength[removeNode];
                changeMode = true;
            }
            if(!changeMode){
                rootGigaLength = Math.max(rootGigaLength, saveLength[removeNode]);
            } else{
                gigaLeafLength = Math.max(saveLength[removeNode], gigaLeafLength);
            }
        }
        if(changeMode){
            System.out.println(rootGigaLength+" "+(gigaLeafLength-rootGigaLength));
        } else {
            System.out.println(rootGigaLength+" "+gigaLeafLength);
        }

    }
}
