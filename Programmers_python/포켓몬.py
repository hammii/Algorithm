def solution(nums):
    nums_set = set(nums)
    return len(nums_set) if len(nums_set) <= len(nums)//2 else len(nums)//2
