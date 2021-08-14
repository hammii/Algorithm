function solution(N) {
    let binary = [];

    while (N > 1) {
        let mod = parseInt(N % 2);
        binary.unshift(mod);
        N = parseInt(N / 2);
    }
    binary.unshift(N);
    binary.push(-1);

    let max_len = 0;
    let cnt = 0;

    for (let i = 1; i < binary.length; i++) {
        if (binary[i] === 0) {
            cnt += 1;
            if (binary[i + 1] === 1) {
                if (cnt > max_len) max_len = cnt;
                cnt = 0;
            }
        }
    }

    return max_len;
}

console.log(solution(1376796946));
