def solution(food):
    answer = '0'
    # print(dir(answer))
    print(food[::-1][:len(food) - 1])
    for i,f in enumerate(food[::-1][:len(food) - 1]):
        for c in range(0, f - 1, 2):
            answer = answer.join([str(len(food) - i - 1),str(len(food) - i - 1)])
    return answer