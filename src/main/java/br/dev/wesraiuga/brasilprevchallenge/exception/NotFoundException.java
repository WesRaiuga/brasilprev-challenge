package br.dev.wesraiuga.brasilprevchallenge.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1104372172047279712L;
	
	public NotFoundException(String message) {
        super(message);
    }
	
	public NotFoundException() {}

}
