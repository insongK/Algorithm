def solution(players, callings):
    players_dict = {p : i for i, p in enumerate(players)}
    for calling in callings:
        i = players_dict[calling]
        
        temp = players[i - 1]
        players[i - 1] = players[i]
        players[i] = temp
        
        players_dict[temp] += 1
        players_dict[calling] -= 1
                             
    return players