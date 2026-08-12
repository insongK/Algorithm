def solution(board, h, w):
    answer = 0
    cur_dir = [h, w]
    dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    for x,y in dirs:
        w_x, w_y = h+x, w+y
        if w_x >=0 and w_x <len(board[0]) and w_y >= 0 and w_y < len(board):
            if board[w_x][w_y] == board[h][w]:
                answer += 1
    return answer