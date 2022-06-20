/**
 * @param {string} s
 * @return {string}
 */
const greatestLetter = function(s) {
  let map = new Map()

  for (let letter of s) {
    let upperCase = letter.toUpperCase()
    let isUpperCase = letter === upperCase

    if (map.get(upperCase)) {
      let cur = map.get(upperCase)
      cur = [cur[0] || isUpperCase, cur[1] || !isUpperCase]
      map.set(upperCase, cur)
    } else {
      map.set(upperCase, [isUpperCase, !isUpperCase])
    }

  }

  let result = []
  for (let [key, value] of map.entries()) {
    if (value[0] && value[1]) {
      result.push(key)
    }
  }
  if (result.length === 0) {
    return ''
  }
  result.sort()

  return result[result.length - 1]
};

console.log(greatestLetter("AbCdEfGhIjK"))