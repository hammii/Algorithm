def solution(land):
    answer = 0
    dp = [[0] * 4 for _ in range(len(land))]

    for i in range(len(land)):
        for j in range(4):
            if i == 0:
                dp[i][j] = land[i][j]
            else:
                max_list = dp[i - 1].copy()
                del max_list[j]
                dp[i][j] = max(max_list) + land[i][j]

    return max(dp[-1])