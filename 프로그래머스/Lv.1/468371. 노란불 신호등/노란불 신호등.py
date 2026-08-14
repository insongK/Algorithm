import math

def calculate_max(signals):
    li = []
    for signal in signals:
        G = signal[0]
        Y = signal[1]
        R = signal[2]
        li.append(G + Y + R)
    return math.prod(li)

def solution(signals):
    max_val = calculate_max(signals)
    li = [0 for i in range(0, max_val)]
    for signal in signals:
        G = signal[0]
        Y = signal[1]
        R = signal[2]
        for i in range(G, max_val, G + R + Y):
            for j in range(i, i + Y):
                if(j >= max_val):
                    break
                li[j] += 1
    answer = 0            
    for idx,i in enumerate(li):
        if(i == len(signals)):
            answer = idx + 1
            break
    
    return answer if answer != 0 else -1

# 2 3 2 2 3 2 2 3 2 2 3
# 3 1 3 3 1 3 3 1 3 3 1
# 2 1 1 2 1 1 2 1 1 2 1
# 4 + 7n 1
# 3 + 4n 2