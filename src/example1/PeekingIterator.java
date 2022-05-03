package example1;

import java.util.Iterator;

/**
 * @author Andrey Ledovskikh
 */
class PeekingIterator<T> implements Iterator<T> {

    final Iterator<T> iterator;
    T peek = null;

    public PeekingIterator(Iterator<T> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        if (peek != null) {
            return this.peek;
        }
        this.peek = this.iterator.next();
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        if (this.peek == null) {
            return this.iterator.next();
        } else {
            var tmp = this.peek;
            this.peek = null;
            return tmp;
        }

    }

    @Override
    public boolean hasNext() {
        if (peek != null) {
            return true;
        }
        return  this.iterator.hasNext();
    }
}
