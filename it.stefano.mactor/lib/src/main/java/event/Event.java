package event;

public class Event implements IEvent {

	private String evType;
	private String content;
	
	public Event(String evType, String content) {
		this.evType = evType;
		this.content = content;
	}
	@Override
	public String getType() {
		return evType;
	}

	@Override
	public String getContent() {
		return content;
	}

}
