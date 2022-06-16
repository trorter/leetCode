/**
 * @param {string} s
 * @return {string}
 */
const longestPalindrome = function(s) {
    if (s.length === 1) {
        return s;
    }

    let maxPalindrome = s[0];

    for (let i = 0; i < s.length - 1; i++) {
        if ((i + 1 < s.length) && s[i] === s[i + 1]) {
            let cur2 = curMaxPalindrome(s, i, i + 1);
            maxPalindrome = maxPalindrome.length < cur2.length ? cur2 : maxPalindrome;
        }

        if ((i + 2 < s.length) && s[i] === s[i + 2]) {
            let cur3 = curMaxPalindrome(s, i, i + 2);
            maxPalindrome = maxPalindrome.length < cur3.length ? cur3 : maxPalindrome;
        }
    }

    return maxPalindrome;
};

/**
 * @param {string} s
 * @param {int} start
 * @param {int} end
 * @returns {string}
 */
const curMaxPalindrome = (s, start, end) => {
    do {
        start--;
        end++;
    } while (0 <= start && end < s.length && s[start] === s[end])

    return s.substring(++start, end);
}

let s = "babad"
console.log(longestPalindrome(s));