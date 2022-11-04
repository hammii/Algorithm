def solution(sizes):
    answer = 0
    sorted_sizes = []

    for s in sizes:
        sorted_sizes.append(sorted(s, reverse=True))

    max_a = sorted_sizes[0][0]
    max_b = sorted_sizes[0][1]
    for s in sorted_sizes:
        if s[0] > max_a:
            max_a = s[0]
        if s[1] > max_b:
            max_b = s[1]

    return max_a * max_b
