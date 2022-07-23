const countBattleships = (board: string[][]): number => {
  let ships = 0

  type Cell = {
    x: number
    y: number
  }

  const findShipEnd = (cell: Cell): Cell => {
    const dirs: Array<Cell> = [
      {x: 0, y: 1},
      {x: 1, y: 0},
    ]

    let finalX = cell.x
    let finalY = cell.y

    let hasNext = true
    while (hasNext) {
      hasNext = false

      for (let dir of dirs) {
        let nextX = finalX + dir.x
        let nextY = finalY + dir.y

        if (nextX === board.length || nextY === board[0].length) {
          continue
        }

        if (board[nextX][nextY] === 'X') {
          finalX = nextX
          finalY = nextY

          hasNext = true
          break
        }
      }
    }

    return {x: finalX, y: finalY}
  }

  const processShip = (start: Cell, end: Cell): void => {
    const dirs: Array<Cell> = [
      {x: 0, y: 0},
      {x: 0, y: 1},
      {x: 1, y: 0},
      {x: 0, y: -1},
      {x: -1, y: 0},
    ]

    for (let x = start.x; x <= end.x; x++) {
      for (let y = start.y; y <= end.y; y++) {
        for (let dir of dirs) {
          const markedX = x + dir.x
          const markedY = y + dir.y

          if (markedX < 0 || markedY < 0 || markedX === board.length || markedY === board[0].length) {
            continue
          }

          board[markedX][markedY] = '-'
        }
      }
    }
  }

  for (let x = 0; x < board.length; x++) {
    for (let y = 0; y < board[0].length; y++) {
      if (board[x][y] === '-' || board[x][y] === '.') {
        continue
      }
      if (board[x][y] === 'X') {
        ships = ships + 1

        processShip({x, y}, findShipEnd({x, y}))
      }
    }
  }

  return ships
}

console.log(countBattleships([["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]))

export {}
