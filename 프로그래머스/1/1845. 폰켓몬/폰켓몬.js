function solution(nums) {
    const poketmon = new Set(nums);
    const pick_num = nums.length / 2
    
    return poketmon.size >= pick_num ? pick_num : poketmon.size;
}