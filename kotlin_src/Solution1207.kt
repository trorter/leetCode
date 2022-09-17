class Solution1207 {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        arr.forEach { item -> map[item] = (map.getOrPut(item) { 0 }) + 1 }

        return map.size == map.values.toSet().size;
    }
}
