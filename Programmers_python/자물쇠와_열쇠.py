def rotate_90(map):
    n = len(map)
    result = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            result[j][n - i - 1] = map[i][j]

    return result


def check(map, n):  # 자물쇠와 열쇠가 맞는지 확인
    for i in range(n, 2 * n):
        for j in range(n, 2 * n):
            if map[i][j] != 1:
                return False

    return True


def solution(key, lock):
    m = len(key)
    n = len(lock)
    big_size = 3 * n
    map = [[0]*big_size for _ in range(big_size)]

    # 1. lock을 3배 크기로 만들고 가운데에 고정한다.
    for i in range(n):
        for j in range(n):
            map[i + n][j + n] = lock[i][j]

    for _ in range(4):
        key = rotate_90(key)  # 2. (0,0)부터 90도로 돌려가며(rotate_90)
        
        for i in range(2 * n):
            for j in range(2 * n):
                for x in range(m):
                    for y in range(m):
                        map[i + x][j + y] += key[x][y]

                # 3. 자물쇠와 열쇠가 맞는지 확인(check) 한다.
                if check(map, n):
                    return True
                
                for x in range(m):
                    for y in range(m):
                        map[i + x][j + y] -= key[x][y]


    return False