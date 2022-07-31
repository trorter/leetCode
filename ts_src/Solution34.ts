const searchRange = (nums: number[], target: number): number[] => {
  if (nums.length === 1) {
    if (nums[0] === target) {
      return [0, 0]
    } else {
      return [-1, -1]
    }
  }

  let start = 0
  let end = nums.length
  let foundIndex = -1
  while (start <= end) {
    const checkedIndex = start + Math.floor((end - start) / 2)

    if (nums[checkedIndex] === target) {
      foundIndex = checkedIndex
      break
    }

    if (nums[checkedIndex] < target) {
      start = checkedIndex + 1
    } else {
      end = checkedIndex - 1
    }
  }

  if (foundIndex === -1) {
    return [-1, -1]
  }

  let firstTargetIndex = foundIndex
  let lastTargetIndex = foundIndex

  let moveNext = true
  while (moveNext) {
    moveNext = false

    if (0 <= firstTargetIndex - 1 && nums[firstTargetIndex - 1] === target) {
      firstTargetIndex -= 1
      moveNext = true
    }

    if (lastTargetIndex + 1 < nums.length && nums[lastTargetIndex + 1] === target) {
      lastTargetIndex += 1
      moveNext = true
    }
  }

  return [firstTargetIndex, lastTargetIndex]
}

console.log(searchRange([1,2,3], 1))

export {}
