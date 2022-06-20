/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
const getLucky = function(s, k) {
  let num = ''
  for (let i = 0; i < s.length; i++) {
    num += s.charCodeAt(i) - 96
  }

  let tmp = 0
  for (let i = 0; i < k; i++) {
    while (0 < num.length) {
      tmp += +num[num.length - 1]
      num = num.substring(0, num.length - 1)
    }

    num = '' + tmp
    tmp = 0
  }

  return +num
}

console.log(getLucky("dbvmfhnttvr", 5))