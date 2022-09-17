const maxNumberOfApples = (weight: number[]): number => {
  weight = weight.sort((a, b) => a - b);

  let sum = 0;
  let count = 0;
  weight.forEach(item => {
    if (sum + item <= 5_000) {
      count += 1;
      sum += item;
    }
  });
  return count;
}

export default maxNumberOfApples;