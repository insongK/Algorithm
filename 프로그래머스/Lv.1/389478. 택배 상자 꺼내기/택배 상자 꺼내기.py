def solution(n, w, num):
    mod = num % w
    if mod == 0:
        mod = w
    
    cnt_1 = 2*w - 1 - 2*(mod - 1)
    cnt_2 = 1 + 2*(mod - 1)
    
    answer = 0
    while(1):
        if answer % 2 == 0:
            num = num + cnt_1
        else:
            num = num + cnt_2
        
        answer = answer + 1
        
        if num > n:
            break
    
    return answer
