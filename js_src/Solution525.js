/**
 * @param {number[]} nums
 * @return {number}
 */
const findMaxLength = function(nums) {
  let max = 0
  let sum = 0
  let map = new Map([[0, -1]])

  nums.forEach((num, i) => {
    sum += num === 0 ? -1 : 1

    if (map.has(sum)) {
      max = Math.max(max, i - map.get(sum))
    } else {
      map.set(sum, i)
    }

  })

  return max
};

//console.log(findMaxLength([1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1]))
//console.log(findMaxLength([1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1]))
console.log(findMaxLength([0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1]))