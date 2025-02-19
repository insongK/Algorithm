class Solution {
    int answer = 0;
    
    public void dfs(int[] numbers, int target, int counter, int sum) {
        if(counter == numbers.length - 1){
            if(target == sum + numbers[counter]) answer++;
            else if(target == sum - numbers[counter]) answer++;
            return;
        }
        
        dfs(numbers, target, counter + 1, sum + numbers[counter]);
        dfs(numbers, target, counter + 1, sum - numbers[counter]);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
}