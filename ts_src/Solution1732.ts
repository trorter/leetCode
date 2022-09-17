const largestAltitude = (gain: number[]): number => {
  let maxA = 0

  let tmp = 0
  for (let x of gain) {
    tmp += x
    maxA = Math.max(maxA, tmp)
  }

  return maxA
}

export default largestAltitude