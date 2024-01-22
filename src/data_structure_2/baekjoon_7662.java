package data_structure_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_7662 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
            for(int k=0; k<K; k++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());
                if(op == 'I'){
                    if(treeMap.containsKey(value)) {
                        treeMap.replace(value, treeMap.get(value) + 1);
                    } else {
                        treeMap.put(value, 1);
                    }
                } else {
                    if(treeMap.isEmpty()){
                        continue;
                    }
                    if(value == -1){ //최소
                        int minKey = treeMap.lastKey();
                        if(treeMap.get(minKey) == 1){
                            treeMap.remove(minKey);
                        } else {
                            treeMap.replace(minKey, treeMap.get(minKey)-1);
                        }
                    } else {
                        int maxKey = treeMap.firstKey();
                        if(treeMap.get(maxKey) == 1){
                            treeMap.remove(maxKey);
                        } else {
                            treeMap.replace(maxKey, treeMap.get(maxKey)-1);
                        }
                    }
                }
            }
            if(treeMap.isEmpty()){
                bw.write("EMPTY");
            } else {
                bw.write(treeMap.firstKey()+" "+treeMap.lastKey());
            }
            bw.write("\n");
        }
        bw.close();
    }
}
