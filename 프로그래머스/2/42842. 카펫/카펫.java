class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w = 0, h = 0;
        
        for(h = 3; h < 2500; h++){
            for(w = h; w < 2500; w++){
                 if(yellow == ((w - 2) * (h - 2)) && brown + 4 == (2 * (w + h))) {
                    answer[0] = w; answer[1] = h;
                    return answer;
                 }
            }
        }
        return answer;
    }
}

