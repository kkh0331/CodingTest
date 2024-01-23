package data_structure_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class baekjoon_4358 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double sum = 0.0;
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String input = "";
        while((input = br.readLine()) != null && !input.isEmpty()){
            sum++;
            if(treeMap.containsKey(input)){
                treeMap.replace(input, treeMap.get(input) + 1);
            } else {
                treeMap.put(input, 1);
            }
        }
        int n = treeMap.size();
        for(int i=0; i<n; i++){
            double ratio = Math.round(treeMap.get(treeMap.firstKey()) / sum * 100 * 10000) /10000.0;
            String temp = String.format("%.4f", ratio);
            bw.write(treeMap.firstKey()+" "+temp+"\n");
            treeMap.remove(treeMap.firstKey());
        }
        bw.close();
    }
}
