function solution(numbers) {
    let answer = '';
    
    numbers = numbers.map(String);
    numbers = numbers.sort((a, b) => {
        return (b+a) - (a+b);
    });
    
    if(parseInt(numbers.join('')) === 0) {
        answer = "0";
    } else {
        answer = numbers.join('');
    }
    
    return answer;
}
