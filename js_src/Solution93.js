/**
 * @param {string} str
 * @return {string[]}
 */
const restoreIpAddresses = (str) => {
  let result = []

  /**
   * @param {number} index
   * @param {number[]} ip
   */
  const dfs = (index, ip) => {
    if (index === str.length) {
      if (ip.length === 4) {
        result = [...result, ip]
      }
      return
    }

    if (ip[ip.length - 1] === 0) {
      dfs(index + 1,  [...ip, +str[index]])
      return
    }

    if ((ip[ip.length - 1] * 10 + +str[index]) <= 255) {
      let newIp = [...ip]
      newIp[ip.length - 1] = (newIp[ip.length - 1] * 10) + +str[index]
      dfs(index + 1,  newIp)
    }
    dfs(index + 1,  [...ip, +str[index]])
  }

  dfs(1, [+str[0]])

  return result.map(item => item.join('.'))
}

console.log(restoreIpAddresses("25525511135"))