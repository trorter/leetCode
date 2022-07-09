const jump = (nums: number[]): number => {
  if (nums.length === 1) {
    return 0
  }

  let jumps: number = 0

  let distance: number = nums[0]
  let lastChecked: number = 0
  while (distance < nums.length - 1) {
    jumps++

    let maxIndex = lastChecked
    let maxDistance = distance
    for (let i = lastChecked + 1; i <= distance; i++) {
      if (maxDistance < i + nums[i]) {
        maxDistance = i + nums[i]
        maxIndex = i
      }
    }

    lastChecked = maxIndex
    distance = maxDistance
  }

  return jumps + 1
}