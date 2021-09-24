N = int(input())
phone_list = []
for i in range(N):
    name, phone = input().split()
    phone_list.append((name, phone))

phone_list.sort()

for i in range(N):
    print(phone_list[i][0], phone_list[i][1])
