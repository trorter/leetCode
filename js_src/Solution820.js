/**
 * @param {string[]} words
 * @return {number}
 */
const minimumLengthEncoding = function (words) {
    const set = new Set(words);
    for(const word of words) {
        for(let k = 1; k < word.length; k++) {
            const w = word.slice(k);
            set.delete(w);
        }
    }
    let ans = 0;
    for(const word of set)
        ans += word.length + 1;
    return ans;
};

// console.log(minimumLengthEncoding(["p","grah","qwosp"]))