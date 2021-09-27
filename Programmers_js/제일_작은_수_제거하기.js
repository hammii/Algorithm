function solution(arr) {
    let min = Infinity;
    let answer = [];

    for (let i = 0; i < arr.length; i++) {
        min = Math.min(min, arr[i]);
    }

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === min) {
            continue;
        }
        answer.push(arr[i]);
    }

    if (answer.length === 0) {
        return [-1];
    }
    return answer;
}
