function solution(numbers, target) {
    let answer = 0;
    
    function dfs(idx, total) {
        if(idx === numbers.length) {
            if(total === target) {
                answer += 1;
            }
            return;
        }

        dfs(idx+1, total+numbers[idx]);
        dfs(idx+1, total-numbers[idx]);
    }
    
    dfs(0, 0);
    return answer;
}
