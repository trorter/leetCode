/**
 * @param {string} num
 * @return {boolean}
 */
const digitCount = function(num) {
  let array = Array.from(Array(num.length), () => 0)
  for (let letter of num) {
    array[+letter] += 1
  }

  for (let i = 0; i < num.length; i++) {
    if (+num[i] !== array[i]) {
      return false
    }
  }

  return true
};

console.log(digitCount("1210"))