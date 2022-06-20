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
    for (let j = num.length - 1; 0 <= j; j-- ) {
      tmp += +num[j]
    }

    num = '' + tmp
    tmp = 0
  }

  return +num
}