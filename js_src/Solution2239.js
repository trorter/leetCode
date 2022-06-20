/**
 * @param {number[]} nums
 * @return {number}
 */
const findClosestNumber = function(nums) {
  let negative = nums.filter(i => i < 0)
  let positives = nums.filter(i => 0 <= i)

  let max = !negative.length ? Number.MIN_SAFE_INTEGER : negative.reduce((r, i) => Math.max(r, i))
  let min = !positives.length ? Number.MAX_SAFE_INTEGER : positives.reduce((r, i) => Math.min(r, i))

  return Math.abs(min) <= Math.abs(max) ? min : max
};

console.log(findClosestNumber([0]))