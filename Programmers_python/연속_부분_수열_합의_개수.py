def solution(elements):
    origin_len = len(elements)
    all_sum = set()
    elements *= 2
    
    for size in range(1, origin_len+1):
        for start in range(origin_len):
            all_sum.add(sum(elements[start:start+size]))
                    
    return len(all_sum)
