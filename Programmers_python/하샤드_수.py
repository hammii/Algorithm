def solution(x):
    xList = list(str(x))
    sumX = sum(map(int, xList))
        
    return True if x % sumX == 0 else False
