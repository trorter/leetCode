/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
const canConstruct = function(ransomNote, magazine) {
    const randomMap = new Map()
    for (letter of ransomNote) {
        randomMap.set(letter, randomMap.has(letter) ? randomMap.get(letter) + 1: 1)
    }

    const magazineMap = new Map()
    for (letter of magazine) {
        magazineMap.set(letter, magazineMap.has(letter) ? magazineMap.get(letter) + 1: 1)
    }

    let result = true;
    randomMap.forEach((value, key) => {
        if (!magazineMap.get(key) || magazineMap.get(key) < value) {
            result = false
        }
    })
    return result
};

console.log(canConstruct('a', 'b'))