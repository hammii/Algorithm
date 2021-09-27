function solution(n) {
    let arr = (n + '').split('');
    arr.sort().reverse();
    return parseInt(arr.join(''));
}
