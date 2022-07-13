const minCostClimbingStairs = (cost: number[]): number => {
  const array: Array<number> = Array.from(Array(cost.length + 1), () => 0)

  for (let i = 2; i < array.length; i++) {
    const prePrev = array[i - 2] + cost[i -2]
    const pre = array[i - 1] + cost[i -1]

    array[i] = Math.min(prePrev, pre)
  }

  return array[array.length - 1]
}

export {}
