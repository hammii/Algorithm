function solution(brown, yellow) {
    let answer = [];
    
    for(let i=1; i<=yellow; i++) {
        let w = i;
        let h = yellow / w;
        
        if(w < h) {
            continue;
        }
        
        if((w+2)*(h+2) - yellow === brown) {
            answer = [w+2, h+2];
            break;
        }
    }
    return answer;
}
