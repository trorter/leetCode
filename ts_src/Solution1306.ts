const canReach = (arr: number[], start: number): boolean => {
  let memo: Array<boolean> = Array.from(new Array(arr.length), () => false)

  const dfs = (index: number): boolean => {
    if (index < 0 || arr.length <= index) {
      return false
    }
    if (arr[index] === 0) {
      return true
    }
    if (memo[index]) {
      return false
    }

    memo[index] = true

    return dfs(index + arr[index]) || dfs(index - arr[index])
  }

  return dfs(start)
}

export {}
