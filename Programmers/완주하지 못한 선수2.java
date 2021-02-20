import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> hashMap = new HashMap<>();

        // participant 추가
        for(String p : participant){
            hashMap.put(p, hashMap.getOrDefault(p, 0)+1);
        } 
        // completion 빼기
        for(String c: completion){
            hashMap.put(c, hashMap.get(c)-1);
        }

        for(String key: hashMap.keySet()){
            if(hashMap.get(key)!=0){
                answer = key;
            }
        }

        return answer;
    }
}