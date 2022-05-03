package example1;

/**
 * @author Andrey Ledovskikh
 */
public class MyHashSet {

    private int[] list = new int[] {
            -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1
    };
    private int currentPosition = 0;

    public MyHashSet() {

    }

    public void add(int key) {
        for(var current
                :this.list) {
            if (current == key) return;
        }

        if (list.length == currentPosition) {
            var newList = new int[list.length * 2];
            for (var i = 0; i < newList.length; i++) {
                newList[i] = -1;
            }

            for(var i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }

            list = newList;
        }

        list[currentPosition] = key;
        currentPosition++;
    }

    public void remove(int key) {
        for(var i = 0; i < list.length; i++) {
            if (list[i] == key) {
                currentPosition--;

                if (i != currentPosition) {
                    list[i] = list[currentPosition];
                }
                list[currentPosition] = -1;
            }
        }
    }

    public boolean contains(int key) {
        for(var current
                :this.list) {
            if (current == key) return true;
        }

        return false;
    }
}
