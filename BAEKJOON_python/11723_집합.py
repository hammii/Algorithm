import sys

M = int(sys.stdin.readline().rstrip())
S = set()

for i in range(M):
    line = sys.stdin.readline().rstrip().split()
    command = line[0]

    if command == 'all':
        S = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
    elif command == 'empty':
        S = set()
    else:
        x = int(line[1])
        if command == 'add':
            if x not in S:
                S.add(x)
        elif command == 'remove':
            if x in S:
                S.remove(x)
        elif command == 'check':
            if x in S:
                print(1)
            else:
                print(0)
        elif command == 'toggle':
            if x in S:
                S.remove(x)
            else:
                S.add(x)
