const isAnagram = (s: string, t: string): boolean => {
  const sLetters = new Map<string, number>()
  for (let letter of s) {
    sLetters.set(letter, (sLetters.get(letter) || 0) + 1)
  }

  const tLetters = new Map<string, number>()
  for (let letter of t) {
    tLetters.set(letter, (tLetters.get(letter) || 0) + 1)
  }

  if (sLetters.size !== tLetters.size) {
    return false
  }

  const keys = Array.from(tLetters.keys())
  for (let key of keys) {
    if (tLetters.get(key) !== sLetters.get(key)) {
      return false
    }
  }

  return true
}

export {}