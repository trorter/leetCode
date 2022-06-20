/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
const findKthPositive = (arr, k) => {
  let count = 0
  let last = 0

  for (let num of arr) {
    while (last + 1 !== num) {
      last++
      count++

      if (count === k) {
        return last
      }
    }

    last = num
  }

  while (count !== k) {
    count++
    last++
  }
  return last
};

console.log(findKthPositive([1,2,3,4], 2))