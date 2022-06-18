/**
 * @param {string[]} words
 */
var WordFilter = function(words) {
    map = new Map()
    for (let i = 0; i < words.length; i++) {
        map.set(words[i], i)
    }

    this.words = map
};

/**
 * @param {string} prefix
 * @param {string} suffix
 * @return {number}
 */
WordFilter.prototype.f = function(prefix, suffix) {
    let maxLength = 0
    let maxWordIndex = -1

    this.words.forEach((index, word) => {

        if (word.startsWith(prefix)
            && word.indexOf(suffix, word.length - suffix.length) !== -1) {
            if (maxLength <= word.length) {
                maxWordIndex = index
                maxLength = word.length
            }
        }
    })

    return maxWordIndex
};

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = new WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */