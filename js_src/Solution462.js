/**
 * @param {number[]} nums
 * @return {number}
 */
const minMoves2 = function(nums) {
  nums = nums.sort((a, b) => a - b)

  let result = 0

  const median = nums[~~(nums.length / 2)]
  nums.forEach(item => result += Math.abs(item - median))

  return result
}

console.log(minMoves2([1,0,0,8,6]))