package oop.demo;

public class CustomException extends Exception {

    public CustomException() {
        // empty
    }

    public CustomException(String message) {
        super(message);
    }

    public static void main(String[] args) throws CustomException {
//        throw new CustomException();
        throw new CustomException("Attention! This is an error.");
    }
}
