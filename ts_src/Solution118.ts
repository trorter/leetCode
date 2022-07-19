const generate = (numRows: number): Array<Array<number>> => {
  const result: Array<Array<number>> = []

  if (numRows === 0) {
    return result
  }

  result.push([1])

  if (numRows === 1) {
    return result
  }

  result.push([1, 1])
  if (numRows === 2) {
    return result
  }

  for (let i = 2; i < numRows; i++) {
    const newRow = [1]

    for (let j = 1; j < i; j++) {
      newRow.push(result[i - 1][j - 1] + result[i - 1][j])
    }

    newRow.push(1)
    result.push(newRow)
  }

  return result
}

export {}

console.log(generate(5))
