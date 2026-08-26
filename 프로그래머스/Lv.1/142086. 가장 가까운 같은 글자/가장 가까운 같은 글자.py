def solution(String):
    map = {}
    answer = []
    for i,s in enumerate(String):
        if map.get(s, -1) == -1: 
            answer.append(-1)
        else:
            answer.append(i - map[s])
        
        map[s] = i
        # print(map)
        
    return answer