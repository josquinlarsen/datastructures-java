package arrays;

public class StaticArrayException extends Exception {
    public StaticArrayException(String message) {
        super(message);
    }
}

class InvalidIndexException extends StaticArrayException {
    public InvalidIndexException(String message) {
        super(message);
    }
}

class EmptyArrayException extends StaticArrayException {
    public EmptyArrayException(String message) {
        super(message);
    }
}
