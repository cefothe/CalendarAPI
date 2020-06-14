package eu.stefanangelov.event.services.exception;

public class EventConflictException extends RuntimeException {

    public EventConflictException() {
    }

    public EventConflictException(String message) {
        super(message);
    }
}
