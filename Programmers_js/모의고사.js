function solution(answers) {
    let supo1=[], supo2=[], supo3=[];
    let s1 = [1,2,3,4,5];
    let s2 = [2,1,2,3,2,4,2,5];
    let s3 = [3,3,1,1,2,2,4,4,5,5];
    let answer = [];
    let answer_cnt = [0,0,0];

    for(let i=0; i<=2000; i++) {
        supo1 = supo1.concat(s1);
        supo2 = supo2.concat(s2);
        supo3 = supo3.concat(s3);
    }
    
    for(let i=0; i<=answers.length; i++) {        
        if(answers[i] === supo1[i]) {
            answer_cnt[0] += 1;
        }
        if(answers[i] === supo2[i]) {
            answer_cnt[1] += 1;
        }
        if(answers[i] === supo3[i]) {
            answer_cnt[2] += 1;
        }
    }
    
    for(let i=1; i<=3; i++) {
        if(answer_cnt[i-1] === Math.max(...answer_cnt)) {
            answer.push(i);
        }
    }
    return answer;
}
