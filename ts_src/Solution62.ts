const uniquePaths = (m: number, n: number): number => {
    if (m === 1 && n === 1) {
        return 1
    }
    let grid = Array.from(Array<number>(m), () => Array<number>(n))

    grid[0].fill(1)
    for (let i = 0; i < m; i++) {
        grid[i][0] = 1
    }

    for (let y = 1; y < m; y++) {
        for (let x = 1; x < n; x++) {
            grid[y][x] = grid[y][x - 1] + grid[y - 1][x]
        }
    }

    return grid[m - 1][n - 1]
}

console.log(uniquePaths(3, 7))

export {}
