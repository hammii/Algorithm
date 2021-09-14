def solution(phone_book):
    phone_book.sort()

    for i in range(len(phone_book) - 1):
        if len(phone_book[i + 1]) >= len(phone_book[i]):
            if phone_book[i + 1].find(phone_book[i]) == 0:
                return False

    return True
