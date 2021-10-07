def solution(n, words):
    word_set = {words[0]}
    n_cnt = [0] * (n + 1)
    n_cnt[1] += 1

    for i in range(1, len(words)):
        num = i % n + 1

        if words[i][0] != words[i - 1][-1] or words[i] in word_set:
            return [num, n_cnt[num] + 1]
        else:
            word_set.add(words[i])
            n_cnt[num] += 1

    return [0, 0]
