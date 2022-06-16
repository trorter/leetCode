/**
 * @param {number} n
 * @return {boolean}
 */
const isHappy = function(n) {
    let memo = []

    while (1 < n) {
        let tmp = 0

        while (0 < n) {
            tmp += (n % 10) ** 2
            n = ~~(n / 10)
        }

        if (memo.includes(tmp)) {
            return false
        }

        memo.push(tmp)
        n = tmp
    }

    return true
};

