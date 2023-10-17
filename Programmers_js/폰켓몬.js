function solution(nums) {
    var answer = 0;
    var nums_set = new Set(nums);
    
    if (nums_set.size < nums.length / 2) {
        answer = nums_set.size;
    } else {
        answer = nums.length / 2;
    }
    
    return answer;
}
