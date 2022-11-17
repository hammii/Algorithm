import math

def solution(progresses, speeds):
    release = []
    answer = []
    
    for i in range(len(progresses)):
        release.append(math.ceil((100-progresses[i]) / speeds[i]))
    
    cnt = 1
    release_max = release[0]
    for i in range(1, len(release)):
        if release_max >= release[i]:
            cnt += 1
        else:
            release_max = release[i]
            answer.append(cnt)
            cnt = 1
            
    answer.append(cnt)    
    return answer
