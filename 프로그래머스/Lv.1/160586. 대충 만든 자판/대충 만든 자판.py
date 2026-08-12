def solution(keymaps, targets):
    dic_key = {}
    answer = [0] * len(targets)
    for i, keymap in enumerate(keymaps):
        for j, key in enumerate(keymap):
            if dic_key.get(key, 100) > j + 1:
                dic_key[key] = j + 1
    
    for i, target in enumerate(targets):
        for t in target:
            count = dic_key.get(t, -1)
            if count == -1:
                answer[i] = -1
                break
            answer[i] += count
                
    return answer