const climbStairs = function (n) {
    let memo = [];
    return climb(memo, n, 0);
};

let climb = (memo, end, step) => {
    if (step === end) {
        return 1;
    }

    if (end < step) {
        return 0;
    }

    if (memo[step]) {
        return memo[step];
    }

    memo[step] = climb(memo, end, step + 1) + climb(memo, end, step + 2);
    return memo[step];
}

console.log(climbStairs(5));