function solution(priorities, location) {
    let answer = 0;
    let idx_queue = [];
    let max = Math.max(...priorities);
    
    for(let i=0; i<priorities.length; i++) {
        idx_queue.push(i);
    }
    
    while(priorities) {
        let front = priorities.shift();
        let front_idx = idx_queue.shift();
        
        if(front < max) {
            priorities.push(front);
            idx_queue.push(front_idx);
        } else {
            answer += 1;
            max = Math.max(...priorities);
            
            if(front_idx == location) {
                break;
            }
        }
    }
    
    return answer;
}
