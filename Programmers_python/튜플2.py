import re
from collections import Counter


def solution(s):
    s = re.findall('\d+', s)    # 숫자만 뽑아내는 정규표현식
    counter = Counter(s)
    counter = sorted(counter.items(), key=lambda x: -x[1])

    answer = []
    for data in counter:
        answer.append(int(data[0]))

    return answer
