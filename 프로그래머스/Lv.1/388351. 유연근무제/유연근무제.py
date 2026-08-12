def solution(schedules, timelogs, startday):
    answer = 0
    for i in range(len(schedules)):
        list = [x // 100 * 60 + x % 100 - (schedules[i] // 100 * 60 + schedules[i] % 100) for x in timelogs[i]]
        
        f = False
        for j in range(len(list)):
            if list[j] > 10:
                if (startday + j) % 7 == 6 or (startday + j) % 7 == 0:
                    continue
                else:
                    f = True
                    break
        if not f:
            answer += 1
    
    return answer