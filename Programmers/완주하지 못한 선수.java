import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> hashMap = new HashMap<>();

        // participant 추가
        for(int i=0;i<participant.length;i++){
            if(hashMap.containsKey(participant[i])){
                hashMap.replace(participant[i], hashMap.get(participant[i])+1);
            }else{
                hashMap.put(participant[i], 1);
            }
        } 

        // completion 빼기
        for(int i=0;i<completion.length;i++){
            if(hashMap.containsKey(completion[i])){
                if(hashMap.get(completion[i])==1){
                    hashMap.remove(completion[i]);
                }else{
                    hashMap.replace(completion[i], hashMap.get(completion[i])-1);
                }
            }
        }

        Iterator iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()){
            answer = iterator.next().toString();
        }

        return answer;
    }
}