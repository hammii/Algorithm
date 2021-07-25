def solution(s):
    if len(s) == 1:
        return 1
    
    answer = 1001
    for length in range(1, len(s) // 2 + 1):
        result = []

        word = s[:length]
        cnt = 1
        idx = length
        while idx <= len(s) - 1:
            cur = s[idx:idx + length]
            if cur == word:  # 이전과 같을 경우
                cnt += 1
            else:
                if cnt == 1:
                    result.append(word)
                else:
                    result.append(str(cnt) + word)

                word = cur
                cnt = 1
            idx += length

        if cnt == 1:
            result.append(word)
        else:
            result.append(str(cnt) + word)

        answer = min(answer, len(''.join(result)))
    return answer