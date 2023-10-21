function solution(numbers) {
    let answer = [];
    let len = numbers.length;
    let stack = [];
    
    for(let i=len-1; i>=0; i--) {
        while(stack.length > 0 && numbers[i] >= stack.at(-1)) {
            stack.pop();
        }
        
        if(stack.length > 0) {
            answer.push(stack.at(-1));
        } else {
            answer.push(-1);
        }
        stack.push(numbers[i]);
    }
    
    return answer.reverse();
}
