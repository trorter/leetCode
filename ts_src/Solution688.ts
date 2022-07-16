const knightProbability = (n: number, k: number, row: number, column: number): number => {
  if (k === 0) {
    return 1
  }

  interface ICell {
    x: number
    y: number
  }

  interface ITakenCell extends ICell{
    count: number
  }

  class Cell implements ICell {
    private readonly _x: number
    private readonly _y: number

    constructor(x: number, y: number) {
      this._x = x
      this._y = y
    }

    get x() {
      return this._x
    }

    get y() {
      return this._y
    }
  }

  class TakenCell extends Cell implements ITakenCell {
    private _count: number

    constructor(x: number, y: number, count: number) {
      super(x, y);
      this._count = count
    }

    get count() {
      return this._count
    }

    set count(value: number) {
      this._count = value
    }
  }

  const dirs: Array<ICell> = [
    new Cell( 1,  2),
    new Cell( 2,  1),
    new Cell( 2, -1),
    new Cell( 1, -2),
    new Cell(-1, -2),
    new Cell(-2, -1),
    new Cell(-2,  1),
    new Cell(-1,  2),
  ]

  let queue: Array<ITakenCell> = []
  queue.push(new TakenCell(row, column, 1))

  let count = 0
  while (count < k) {

    const newQueue: Array<ITakenCell> = []

    for (let cell of queue) {
      for (let dir of dirs) {
        const nextX = cell.x + dir.x
        const nextY = cell.y + dir.y

        if (nextY < 0 || nextX < 0 || n <= nextX || n <= nextY) {
          continue
        }

        const foundedCell = newQueue.find(item => item.x === nextX && item.y === nextY)
        if (foundedCell) {
          foundedCell.count = foundedCell.count + cell.count
        } else {
          newQueue.push(new TakenCell(nextX, nextY, cell.count))
        }
      }
    }

    count += 1
    queue = newQueue
  }

  return queue.reduce((sum, item) => sum + item.count, 0) / Math.pow(8, k)
}

console.log(knightProbability(3,
2,
0,
0))

export {}
