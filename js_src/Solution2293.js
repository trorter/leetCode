/**
 * @param {number[]} nums
 * @return {number}
 */
const minMaxGame = function(nums) {
  if (nums.length === 1) {
    return nums[0]
  }

  let array = []
  while (nums.length !== 1) {

    let count = 1
    for (let i = 0; i < nums.length; i += 2) {
      if (count % 2 === 1) {
        array.push(Math.min(nums[i], nums[i + 1]))
      } else {
        array.push(Math.max(nums[i], nums[i + 1]))
      }

      count++
    }

    nums = array
    array = []
  }

  return nums[0]
};

console.log(minMaxGame([1,3,5,2,4,8,2,2]))