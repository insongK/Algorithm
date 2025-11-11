import string

def solution(s, skip, index):
    answer = ''
    s = list(s)
    skip = list(skip)

    alpha = list(string.ascii_lowercase)
    alpha = [x for x in alpha if x not in skip]
    
    for _ in s:
        answer += alpha[(alpha.index(_) + index) % len(alpha)]
    
            
        
    return answer