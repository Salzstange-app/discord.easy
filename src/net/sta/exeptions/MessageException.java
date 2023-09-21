package net.sta.exeptions;

public class MessageException extends Exception{
	
	@Override
	public String getMessage() {
		return "Ich wurde ausgelöst";
	}
	public void firstException() {
		
	}

}
