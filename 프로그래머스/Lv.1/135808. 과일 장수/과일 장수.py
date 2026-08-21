def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)
    # print(score)
    
    for i in range(0,len(score),m):
        if i + m - 1 < len(score):
            answer += m * score[i + m - 1]

    return answer