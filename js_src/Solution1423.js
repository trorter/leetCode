/**
 * @param {number[]} cardPoints
 * @param {number} k
 * @return {number}
 */
const maxScore = function(cardPoints, k) {
  const totalSum = cardPoints.reduce((sum, next) => sum + next)

  if (cardPoints.length === k) {
    return totalSum
  }

  let left = k - 1
  let right = cardPoints.length

  let minWinSum = cardPoints
    .filter((item, index) => left < index && index < right)
    .reduce((sum, item) => sum + item)
  let curWinSum = minWinSum

  while (0 <= left) {
    curWinSum = curWinSum + (left < 0 ? 0 : cardPoints[left--]) - cardPoints[--right]
    minWinSum = Math.min(
      minWinSum, curWinSum)
  }
  return totalSum - minWinSum
};

console.log(maxScore([1,2,3,4,5,6,1],3))