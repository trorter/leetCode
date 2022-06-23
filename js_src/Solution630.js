/**
 * @param {number[][]} courses
 * @return {number}
 */
const scheduleCourse = function(courses) {
  courses = courses.filter(item => item[0] <= item[1])

  if (!courses.length) {
    return 0
  }

  courses.sort((a, b) => a[1] - b[1])

  let count = 0
  let time = 0
  for (let i = 0; i < courses.length; i++) {
    if (courses[i][0] + time <= courses[i][1]) {
      count++
      time += courses[i][0]
    } else {
      let maxIndex = -1
      let maxTime = Number.MIN_SAFE_INTEGER

      for (let j = 0; j < i; j++) {
        if (courses[i][0] < courses[j][0]) {
          if (maxTime < courses[j][0]) {
            maxTime = courses[j][0]
            maxIndex = j
          }
        }
      }

      if (0 <= maxIndex) {
        time -= courses[maxIndex][0]
        time += courses[i][0]

        courses[maxIndex][0] = -1
      } else {
        courses[i][0] = -1
      }
    }
  }

  return count
};

// console.log(scheduleCourse([[3,5],[5,7],[10,14],[4,16],[10,18]]))
// console.log(scheduleCourse([[1,19],[2,2],[1,17]]))
// console.log(scheduleCourse([[860,4825],[13,1389],[746,8823],[455,2778],[233,2069],[106,5648],[802,2969],[958,2636],[567,2439],[623,1360],[700,4206],[9,3725],[241,7381]]))
console.log(scheduleCourse([[5,5],[4,6],[2,6]]))