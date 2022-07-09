const canJump = (nums: number[]): boolean => {
  let maxJump: number = 0

  for (let i = 0; i < nums.length && i <= maxJump; i++) {
    maxJump = Math.max(maxJump, i + nums[i])
  }

  return nums.length <= maxJump + 1
}