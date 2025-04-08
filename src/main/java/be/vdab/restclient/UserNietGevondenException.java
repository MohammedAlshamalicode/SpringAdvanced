package be.vdab.restclient;

public class UserNietGevondenException extends RuntimeException {
    public UserNietGevondenException( ) {
        super("User niet gevonden .");
    }
}
