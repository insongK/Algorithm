class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees){
            boolean flag = false;
            for(int i = 0; i < skill.length() - 1; i++){
                int temp1 = skill_tree.indexOf(skill.charAt(i)) == -1 ? 
                            20 : skill_tree.indexOf(skill.charAt(i));
                int temp2 = skill_tree.indexOf(skill.charAt(i + 1)) == -1 ? 
                            20 : skill_tree.indexOf(skill.charAt(i + 1));
                if(temp1 > temp2){
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }
        return answer;
    }
}