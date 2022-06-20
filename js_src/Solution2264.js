/**
 * @param {string} num
 * @return {string}
 */
const largestGoodInteger = function(num) {
  let result = -1

  let map = new Map()
  for (let i = 0; i < num.length; i++) {
    if (!map.has(num[i])) {
      map.set(num[i], [i])

    } else {
      let indexes = map.get(num[i])
      indexes.push(i)

      if (indexes[indexes.length - 2] + 1 === indexes[indexes.length - 1]) {
        if (indexes.length === 3) {
          result = Math.max(result, +num[i])
        }
      } else {
        map.set(num[i], [i])
      }
    }
  }

  return result === -1 ? "" : '' + result + result + result
};

console.log(largestGoodInteger("711133310755088231390684011112227777007142226669892017313336662051880002555771116"))