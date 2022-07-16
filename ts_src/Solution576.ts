const findPaths = (m: number, n: number, maxMove: number, startRow: number, startColumn: number): number => {
  interface Cell {
    x: number
    y: number
  }

  interface TakenCell extends Cell {
    counter: number
  }

  const dirs = [
    new class implements Cell {
      x = 0;
      y = 1
    },
    new class implements Cell {
      x = 0;
      y = -1
    },
    new class implements Cell {
      x = 1;
      y = 0
    },
    new class implements Cell {
      x = -1;
      y = 0
    },
  ]

  let resultCounter = 0
  const modulo = 1_000_000_007

  let queue: Array<TakenCell> = []
  queue.push(new class implements TakenCell {
    x = startRow;
    y = startColumn;
    counter = 1;
  })

  let counter = 0
  while (counter < maxMove) {

    const nextQueue: Array<TakenCell> = []

    for (let cell of queue) {
      for (let dir of dirs) {
        const nextX = cell.x + dir.x
        const nextY = cell.y + dir.y

        if (nextX < 0 || nextY < 0 || m === nextX || n === nextY) {
          resultCounter = (resultCounter + cell.counter) % modulo
          continue
        }

        const foundedBolls = nextQueue.find(curCell => curCell.x === nextX && curCell.y === nextY)
        if (foundedBolls) {
          foundedBolls.counter = (foundedBolls.counter + cell.counter) % modulo
        } else {
          nextQueue.push(new class implements TakenCell {
            x = nextX;
            y = nextY;
            counter = cell.counter;
          })
        }
      }
    }

    queue = nextQueue
    counter++
  }

  return resultCounter
}

console.log(findPaths(36,
5,
50,
15,
3))

export {}
