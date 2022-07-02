/**
 * @param {number} h
 * @param {number} w
 * @param {number[]} horizontalCuts
 * @param {number[]} verticalCuts
 * @return {number}
 */
const maxArea = function(h, w, horizontalCuts, verticalCuts) {
  const modulo = BigInt(10**9 + 7)

  horizontalCuts = horizontalCuts.sort((a, b) => a-b)
  verticalCuts = verticalCuts.sort((a, b) => a-b)

  let horizons = [0, ...horizontalCuts, h]
  let verticals = [0, ...verticalCuts, w]

  let maxH = 0
  for (let i = 1; i < horizons.length; i++) {
    maxH = Math.max(maxH, horizons[i] - horizons[i - 1])
  }

  let maxV = 0
  for (let i = 1; i < verticals.length; i++) {
    maxV = Math.max(maxV, verticals[i] - verticals[i - 1])
  }

  return Number((BigInt(maxV) * BigInt(maxH)) % modulo)
}


console.log(maxArea(1_000_000_000, 1_000_000_000, [2], [2]))