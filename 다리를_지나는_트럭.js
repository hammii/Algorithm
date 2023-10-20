function solution(bridge_length, weight, truck_weights) {
    let answer = 0;
    let bridge = Array.from({length: bridge_length}, () => 0);
    let bridge_sum = 0;
    
    while(bridge.length > 0) {
        answer += 1;
        bridge_sum -= bridge.shift();
        
        if(truck_weights.length > 0) {
            if(bridge_sum + truck_weights[0] <= weight) {
                bridge_sum += truck_weights[0]; 
                bridge.push(truck_weights.shift());
            } else {
                bridge.push(0);
            }
        }
    }
    
    return answer;
}
