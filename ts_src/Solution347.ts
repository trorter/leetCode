const topKFrequent = (nums: Array<number>, k: number): Array<number> => {
    const map = new Map<number, number>()

    for(let num of nums) {
        map.set(num, (map.get(num) || 0) + 1)
    }

    return [...map.entries()].sort((a, b) => b[1] - a[1]).slice(0, k).map(a => a[0])
}

export {}
