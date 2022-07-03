/**
 * @param {number[][]} mat
 * @return {number}
 */
const diagonalSum = (mat) => {
  let sum = 0
  for (let i = 0; i < mat.length; i++) {
    sum += mat[i][i]
    if (i !== mat.length -1 - i) {
      sum += mat[mat.length -1 - i][i]
    }
  }
  return  sum
}

const mat = [[7,3,1,9],[3,4,6,9],[6,9,6,6],[9,5,8,5]]
console.log(diagonalSum(mat))