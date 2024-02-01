package data_structure_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class baekjoon_21942 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] L = st.nextToken().split("/");
        int addDay = Integer.parseInt(L[0]);
        int addHour = Integer.parseInt(L[1].split(":")[0]);
        int addMinute = Integer.parseInt(L[1].split(":")[1]);
        long rentalPeriod = (addDay* 24L + addHour)*60 + addMinute;
        int F = Integer.parseInt(st.nextToken());
        TreeMap<String, String> saveMap = new TreeMap<>();
        TreeMap<String, Long> resMap = new TreeMap<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String inputDay = st.nextToken() + " " + st.nextToken();
            String inputString = st.nextToken() + " " + st.nextToken();
            if(saveMap.containsKey(inputString)){
                long beforeTime = sdf.parse(saveMap.remove(inputString)).getTime();
                long afterTime = sdf.parse(inputDay).getTime();
                long diff = (afterTime - beforeTime)/60000 - rentalPeriod;
                if(diff > 0){
                    long pay = diff*F;
                    String person = inputString.split(" ")[1];
                    if(resMap.containsKey(person)){
                        resMap.replace(person, resMap.get(person)+pay);
                    } else {
                        resMap.put(person, pay);
                    }
                }
            } else {
                saveMap.put(inputString, inputDay);
            }
        }
        int n = resMap.size();
        if(n == 0){
            bw.write("-1");
        } else {
            for(int i=0; i<n; i++){
                bw.write(resMap.firstKey()+" "+resMap.remove(resMap.firstKey())+"\n");
            }
        }
        bw.close();
    }
}
