def solution(keymap, targets):
    maps = {}
    for key in keymap:
        for i,k in enumerate(key):
            if(maps.get(k) == None):
                maps[k] = i + 1
            else:
                maps[k] = min(maps.get(k), i + 1)
                
    print(maps)
    answer = [0 for i in range(len(targets))]
    for i,target in enumerate(targets):
        for t in target:
            if(maps.get(t) == None):
                answer[i] = -1
                break
            else:
                answer[i] += maps[t]
    
    return answer


