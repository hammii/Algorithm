function solution(prices) {
    var answer = [];
    
    for(let i=0; i<prices.length-1; i++) {
        let time = 0;
        for(let j=i+1; j<prices.length; j++) {
            time += 1;
            if(prices[i] > prices[j]) {
                break;
            }
        }
        answer.push(time);
    }
    answer.push(0);
    
    return answer;
}
