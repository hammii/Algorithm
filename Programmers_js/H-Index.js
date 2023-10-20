function solution(citations) {
    let answer = 0;
    
    citations.sort();
    for(let h=0; h<=10000; h++) {
        let left = 0, right = 0;
         
        for(let i=0; i<citations.length; i++) {
            if(citations[i] < h) {
                left += 1;
            } else {
                right += 1;
            }
        }
        
        if(left < h && h <= right) {
            answer = h;
        }
    }
    
    return answer;
}
