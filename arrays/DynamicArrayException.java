package arrays;

public class DynamicArrayException extends StaticArrayException {
    public DynamicArrayException(String message) {
        super(message);
    }
}

class InvalidIndexException extends DynamicArrayException {
    public InvalidIndexException(String message) {
        super(message);
    }
}

class EmptyArrayException extends DynamicArrayException {
    public EmptyArrayException(String message) {
        super(message);
    }
}

