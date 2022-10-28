def solution(price, money, count):
    priceN = 0

    for i in range(1, count+1):
        priceN += price * i

    if money >= priceN:
        return 0
    else:
        return priceN - money
