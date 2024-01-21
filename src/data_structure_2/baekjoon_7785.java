package data_structure_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_7785 {
    public static void main(String[] src) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> treeSet = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            if(log.equals("enter")){
                treeSet.add(name);
            } else { // "leave"
                treeSet.remove(name);
            }
        }
        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            bw.write(iterator.next()+"\n");
        }
        bw.close();
    }
}
