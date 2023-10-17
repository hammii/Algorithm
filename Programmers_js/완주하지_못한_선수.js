function solution(participant, completion) {    
    const map = new Map();

    for(let i=0; i<participant.length; i++) {
        let p = participant[i];
        map.set(p, (map.get(p)||0) + 1);
    }
    
    for(let i=0; i<completion.length; i++) {
        let c = completion[i];
        map.set(c, (map.get(c)||0) - 1);
    }
    
    for(let [k, v] of map) {
        if(v > 0) return k;
    }
}
