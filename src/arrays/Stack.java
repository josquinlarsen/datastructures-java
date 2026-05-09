package arrays;

class StackException extends DynamicArrayException {
    StackException(String message) {
        super(message);
    }
}

public class Stack<T> extends DynamicArray<T> {
    public Stack() throws StackException, DynamicArrayException, StaticArrayException{
        super();
    }

    public void push(T item) {
        append(item);
    }

    public T top() {
        return data[size - 1];
    }

    // inherits pop
}
