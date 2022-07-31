class NumArray {
  nums: number[]

  constructor(nums: number[]) {
    this.nums = nums
  }

  update(index: number, val: number): void {
    if (this.nums.length < index) {
      return
    }
    this.nums[index] = val
  }

  sumRange(left: number, right: number): number {
    let result = 0
    for (let i = left; i <= right; i++) {
      result += this.nums[i]
    }
    return result
  }
}

export {}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * obj.update(index,val)
 * var param_2 = obj.sumRange(left,right)
 */