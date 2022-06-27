/**
 * @param {string} n
 * @return {number}
 */
const minPartitions = function(n) {
  let max = Number.MIN_SAFE_INTEGER
  for (let letter of n) {
    max = Math.max(max, +letter)
  }
  return max
}

console.log(minPartitions("27346209830709182346"))