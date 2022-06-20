/**
 * @param {number[][]} brackets
 * @param {number} income
 * @return {number}
 */
const calculateTax = function(brackets, income) {
  if (income === 0) {
    return 0
  }

  let result = 0
  let lastIncome = 0
  for (let bracket of brackets) {
    if (income < bracket[0]) {
      result += (income - lastIncome) * bracket[1] / 100
      break
    }

    result += (bracket[0] - lastIncome) * bracket[1] / 100
    lastIncome = bracket[0]
  }

  return result
};

console.log(calculateTax([[3,50],[7,10],[12,25]], 10))