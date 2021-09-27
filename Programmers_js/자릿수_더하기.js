function solution(n) {
    const num = n.toString();
    let answer = 0;

    for (let i = 0; i < num.length; i++) {
        answer += parseInt(num[i]);
    }
    return answer;
}
