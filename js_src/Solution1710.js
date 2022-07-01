/**
 * @param {number[][]} boxTypes
 * @param {number} truckSize
 * @return {number}
 */
const maximumUnits = function(boxTypes, truckSize) {
  boxTypes = boxTypes.sort((a, b) => b[1] - a[1])

  let result = 0
  let count = 0
  while (count < boxTypes.length && boxTypes[count][0] <= truckSize) {
    result += boxTypes[count][0] * boxTypes[count][1]
    truckSize -= boxTypes[count][0]
    count++
  }

  if (count < boxTypes.length) {
    result += truckSize * boxTypes[count][1]
  }

  return result
}

console.log(maximumUnits([[5,10],[2,5],[4,7],[3,9]], 10))