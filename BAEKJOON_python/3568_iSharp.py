import sys

line = sys.stdin.readline().rstrip().split()

for i in range(1, len(line)):
    line[i] = line[i].replace(',', '').replace(';', '')
    result = line[0]

    for j in range(len(line[i]) - 1, 0, -1):  # 뒤에서부터
        if line[i][j] in '*[]&':
            if line[i][j] == ']':
                pass
            elif line[i][j] == '[':
                result += '[]'
            else:
                result += line[i][j]
            line[i] = line[i][:-1]
        else:
            break
    print(result, line[i], end='')
    print(';')
