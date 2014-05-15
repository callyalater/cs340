package client.models;

import client.models.translator.TRMessageLine;

public class MessageLine{
	protected String message;
	protected String source;
	
	public MessageLine(TRMessageLine line) {
		this.message = line.getMessage();
		this.source = line.getSource();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TRMessageLine [message=");
		builder.append(message);
		builder.append(", source=");
		builder.append(source);
		builder.append("]");
		return builder.toString();
	}
}
