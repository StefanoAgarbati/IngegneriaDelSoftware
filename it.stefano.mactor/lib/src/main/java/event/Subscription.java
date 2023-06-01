package event;

import mactor.interfaces.IMActor;

public class Subscription {

	private String evType;
	private IMActor subscriber;
	
	public Subscription(String evType, IMActor subscriber) {
		this.evType = evType;
		this.subscriber = subscriber;
	}

	public String getEvType() {
		return evType;
	}

	public IMActor getSubscriber() {
		return subscriber;
	}
	
}
