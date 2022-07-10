const myAtoi = (s: string): number => {
  let i: number = 0
  let num: number = 0
  let sign: number = 1
  let max: number = 2**31 - 1
  let min: number = 2**31 * -1

  s = s.trim();

  if (s[i] === '-' || s[i] === '+') {
    sign = s[i] === '-' ? -1 : 1
    i++
  }

  while (s[i] !== ' ' && 0 <= +s[i] && +s[i] <= 9) {
    num = num * 10 + +s[i]
    i ++
  }

  num = num * sign

  return num <= min ? min : max <= num ? max : num
}