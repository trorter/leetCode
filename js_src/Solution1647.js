/**
 * @param {string} s
 * @return {number}
 */
const minDeletions = function(s) {
  let map = new Map()

  for (let letter of s) {
    map.set(letter, map.has(letter) ? map.get(letter) + 1 : 1)
  }

  let count = 0
  let row = Array.from(map.values()).sort((a, b) => a - b)
  let isGood = false

  while (!isGood) {
    isGood = true

    for (let i = 0; i < row.length - 1; i++) {
      if (row[i] !== 0 && row[i] === row[i + 1]) {
        row[i]--
        count++
        isGood = false
        break
      }
    }
  }

  return count
}

console.log(minDeletions("bbcebab"))