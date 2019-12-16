package dev.lenic.timetracking.exception;

public class CreateResourceException extends BaseException {

    public CreateResourceException(String message) {
        super("CREATE_RESOURCE_FAILED");
    }

}
