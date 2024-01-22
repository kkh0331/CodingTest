package data_structure_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_21939 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, TreeSet<Integer>> treeMap = new TreeMap<>(); // 난이도, 난이도에 해당하는 문제번호 Queue
        TreeMap<Integer, Integer> treeMap1 = new TreeMap<>(); //문제번호, 난이도
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            treeMap1.put(P, L);
            if(!treeMap.containsKey(L)){
                treeMap.put(L, new TreeSet<>());
            }
            treeMap.get(L).add(P);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("add")){
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                if(treeMap1.containsKey(P)){
                    int preL = treeMap1.get(P);
                    treeMap1.replace(P, L);
                    treeMap.get(preL).remove(P);
                    treeMap.get(L).add(P);
                } else {
                    treeMap1.put(P, L);
                    if(!treeMap.containsKey(L)){
                        treeMap.put(L, new TreeSet<>());
                    }
                    treeMap.get(L).add(P);
                }
            } else if(input.equals("solved")){
                int P = Integer.parseInt(st.nextToken());
                int L = treeMap1.remove(P);
                treeMap.get(L).remove(P);
                if(treeMap.get(L).isEmpty()){
                    treeMap.remove(L);
                }
            } else {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){
                    bw.write(treeMap.get(treeMap.lastKey()).last()+"\n");
                } else {
                    bw.write(treeMap.get(treeMap.firstKey()).first()+"\n");
                }
            }
        }
        bw.close();
    }
}
