def solution(record):
    answer = []
    result = []
    uid_dict = {}

    for r in record:
        line = r.split()
        command = line[0]
        uid = line[1]

        if command == "Enter":
            result.append((command, uid))
            uid_dict[uid] = line[2]
        elif command == "Leave":
            result.append((command, uid))
        else:
            uid_dict[uid] = line[2]

    for command, uid in result:
        if command == "Enter":
            answer.append(uid_dict[uid] + "님이 들어왔습니다.")
        else:
            answer.append(uid_dict[uid] + "님이 나갔습니다.")

    return answer
