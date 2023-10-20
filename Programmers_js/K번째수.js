function solution(array, commands) {
    let answer = [];
    
    for(let idx=0, len=commands.length; idx<len; idx++) {
        let i = commands[idx][0] - 1;
        let j = commands[idx][1];
        let k = commands[idx][2] - 1;
        let command = array.slice(i, j).sort((a,b) => a-b);

        answer.push(command[k]);
    }
    
    return answer;
}
