package components;

public class CustomException extends Exception{ //custom exception calss can be created extending exception class
    public CustomException (String str) { //constructor is created to call the exception with the message string
        super(str);//super is used to call the super class constructor that accepts string
    }
}
