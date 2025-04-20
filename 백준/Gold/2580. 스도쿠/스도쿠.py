import sys

input = sys.stdin.readline

sudoku = [list(map(int, input().split())) for _ in range(9)]
zeros = [(i, j) for i in range(9) for j in range(9) if sudoku[i][j] == 0]
solved = False


def print_sudoku():
    for row in sudoku:
        print(" ".join(map(str, row)))


def is_valid(r, c, num):
    if num in sudoku[r]:
        return False
    for i in range(9):
        if sudoku[i][c] == num:
            return False
    box_r, box_c = (r // 3) * 3, (c // 3) * 3
    for i in range(box_r, box_r + 3):
        for j in range(box_c, box_c + 3):
            if sudoku[i][j] == num:
                return False
    return True


def dfs(idx):
    global solved
    if solved:
        return
    if idx == len(zeros):
        print_sudoku()
        solved = True
        return
    r, c = zeros[idx]
    for num in range(1, 10):
        if is_valid(r, c, num):
            sudoku[r][c] = num
            dfs(idx + 1)
            sudoku[r][c] = 0


dfs(0)
