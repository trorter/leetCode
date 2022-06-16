/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let min = Number.MAX_SAFE_INTEGER
    let result = 0
    for (let price of prices) {
        if (price < min) {
            min = price
        } else {
            result = Math.max(result, price - min)
        }
    }

    return result;
};

console.log(maxProfit([7,6,4,3,1]))