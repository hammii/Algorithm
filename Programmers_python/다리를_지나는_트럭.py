from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = deque([0]) * bridge_length
    bridge_sum = 0
    time = 0
    
    while bridge:
        time += 1
        
        bridge_sum -= bridge.popleft()
        
        if truck_weights:
            if truck_weights[0] + bridge_sum <= weight:
                bridge_sum += truck_weights[0]
                bridge.append(truck_weights.pop(0))
            else:
                bridge.append(0)
        
    return time
