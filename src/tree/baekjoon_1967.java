package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1967 {

    public static List<Map<Integer,Integer>> map;
    public static int res = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new ArrayList<>();
        for(int i=0; i<=n; i++){
            map.add(new Hashtable<>());
        }
        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int descendant = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            map.get(parent).put(descendant, distance);
        }
        returnDistance(1);
        System.out.println(res);
    }

    public static int returnDistance(int head){
        if(map.get(head).size() == 0) return 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int key : map.get(head).keySet()){
            int returnValue = returnDistance(key);
            priorityQueue.offer(map.get(head).get(key) + returnValue);
        }
        if(priorityQueue.size() == 1){
          int a = priorityQueue.remove();
          if(a > res) res = a;
          return a;
        } else {
            int a = priorityQueue.remove();
            int b = priorityQueue.remove();
            if(a+b > res) res = a+b;
            return a;
        }
    }
}
