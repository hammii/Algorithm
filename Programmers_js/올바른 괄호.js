function solution(s){
    let answer = true;
    const stack = [];
    
    for(let i=0, len=s.length; i<len; i++) {
        if(s[i] === "(") {
            stack.push("(");
        } else if(s[i] === ")") {
            if(stack.length == 0) {
                answer = false;
                break;
            }
            
            if(stack[stack.length-1] === "(") {
                stack.pop();
                continue;
            } else if(stack[stack.length-1] === ")") {
                answer = false;
                break;
            }
        }
    }

    if(stack.length > 0) {
        answer = false;
    }
    
    return answer;
}
