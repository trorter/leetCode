package example1;

/**
 * @author Andrey Ledovskikh
 */
public class MyHashMap {

    class ListNodeMap {
        int key;
        int value;
        ListNodeMap next;
        ListNodeMap() {}
        ListNodeMap(int key, int value) { this.key = key; this.value = value;}
        ListNodeMap(int key, int value, ListNodeMap next) { this.key = key; this.value = value; this.next = next; }

        @Override
        public String toString() {
            return "ListNodeMap{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private ListNodeMap map = null;

    public MyHashMap() {

    }

    public void put(int key, int value) {
        if (map == null) {
            map = new ListNodeMap(key, value);
            return;
        }

        var tmp = map;
        while (tmp != null) {
            if (tmp.key == key) {
                tmp.value = value;
                return;
            }

            tmp = tmp.next;
        }

        map = new ListNodeMap(key, value, map);
    }

    public int get(int key) {
        if (map == null) return -1;

        var tmp = map;
        while (tmp != null) {
            if (tmp.key == key) {
                return tmp.value;
            }

            tmp = tmp.next;
        }

        return -1;
    }

    public void remove(int key) {
        if (map == null) return;

        var tmp = map;
        var prev = map;

        while (tmp != null) {
            if (tmp.key == key) {

                if (tmp == map) {
                    map = map.next;
                } else {
                    prev.next = tmp.next;
                }
                return;
            }

            prev = tmp;
            tmp = tmp.next;

        }
    }
}
