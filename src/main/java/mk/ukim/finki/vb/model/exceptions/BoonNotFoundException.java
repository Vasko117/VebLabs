package mk.ukim.finki.vb.model.exceptions;

public class BoonNotFoundException extends RuntimeException{
    public BoonNotFoundException() {
        super("No book found.");
    }

}
