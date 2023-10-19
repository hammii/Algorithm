function solution(progresses, speeds) {
    let answer = [];
    let days = [];
    
    for(let i=0,len=speeds.length; i<len; i++) {
        days[i] = Math.ceil((100 - progresses[i]) / speeds[i]);
    }
    
    answer.push(1);
    let max_day = days[0];
    
    for(let i=1, len=days.length; i<len; i++) {
        if(max_day >= days[i]) {
            answer.push(answer.pop() + 1);
        } else {
            answer.push(1);
            max_day = days[i];
        }
    }
    
    return answer;
}
