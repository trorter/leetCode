const searchMatrix = (matrix: number[][], target: number): boolean => {
  const xLen = matrix.length
  const yLen = matrix[0].length

  if (target < matrix[0][0] || matrix[xLen - 1][yLen - 1] < target) {
    return false
  }

  let xStart = -1
  let xEnd = -1
  for (let x = 0; x < xLen; x++) {
    if (matrix[x][0] <= target && target <= matrix[x][yLen - 1]) {
      if (xStart === -1) {
        xStart = x
      }

      xEnd = x
    }
  }

  let yStart = -1
  let yEnd = -1
  for (let y = 0; y < yLen; y++) {
    if (matrix[0][y] <= target && target <= matrix[xLen - 1][y]) {
      if (yStart === -1) {
        yStart = y
      }

      yEnd = y
    }
  }

  if (xStart < 0) {
    return false
  }

  for (let x = xStart; x <= xEnd; x++) {
    for (let y = yStart; y <= yEnd; y++) {
      if (matrix[x][y] === target) {
        return true
      }
    }
  }

  return false
}

console.log(searchMatrix([[1],[3],[5]], 2))

export {}