function solution(arr1, arr2) {
    let answer = [];

    for (let i = 0; i < arr1.length; i++) {
        let temp = [];
        for (let j = 0; j < arr1[i].length; j++) {
            temp[j] = arr1[i][j] + arr2[i][j];
        }
        answer[i] = temp;
    }
    return answer;
}
