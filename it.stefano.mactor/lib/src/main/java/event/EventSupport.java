package event;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventSupport extends Thread {

	private static EventSupport instance;
	
	private BlockingQueue<IEvent> eventQueue = new LinkedBlockingQueue<>();
	private Map<String, List<ISubscriber>> subscriptions = new HashMap<>();
	
	public static EventSupport getInstance() {
		if(instance == null) {
			instance = new EventSupport();
		}
		return instance;
	}
	
	private EventSupport() {
		this.start();
	}
	public void run() {
		mainLoop();
	}
	public void subscribe(String evType, ISubscriber subscriber) {
		addSubscription(evType, subscriber);
		System.out.println("EventSupport | subscription added " + subscriber + " " + evType);
		
	}
	public void unsubscribe(String evType, ISubscriber subscriber) {
		List<ISubscriber> subscribers = subscriptions.get(evType);
		subscribers.remove(subscriber);
		if(subscribers.isEmpty())
			subscriptions.remove(evType);
	}
	private void addSubscription(String evType, ISubscriber subscriber) {
		List<ISubscriber> subscribersForEvent = subscriptions.get(evType);
		if(subscribersForEvent == null) {
			List<ISubscriber> subscribers = new LinkedList<>();
			subscriptions.put(evType, subscribers);
			subscribers.add(subscriber);
			System.out.println("EventSupport | addSubscription " + subscriber + " " + evType);
			return;
		}
		subscribersForEvent.add(subscriber);
		System.out.println("EventSupport | addSubscription " + subscriber + " " + evType);
	}

	public void publish(String evType, String ev) {
		IEvent event = new Event(evType, ev);
		System.out.println("EventSupport | event created " + event.getType() + " " + event.getContent());
		enqueueEvent(event);
		System.out.println("EventSupport | event published " + evType + " " + ev);
	}
	
	private void enqueueEvent(IEvent event) {
		try {
			eventQueue.put(event);
			System.out.println("EventSupport | event enqueued " + event.getType() + " " + event.getContent());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void mainLoop() {
		while(true) {
			IEvent event = dequeueEvent();
			System.out.println("EventSupport | event dequeued " + event.getType() + " " + event.getContent());
			dispatchEvent(event);
			System.out.println("EventSupport | event dispatched " + event.getType() + " " + event.getContent());
		}
	}

	private void dispatchEvent(IEvent event) {
		List<ISubscriber> subscribers = getSubscribers(event.getType());
		//System.out.println("EventSupport | subscribers " + subscribers.toString());
		if(subscribers != null)
			subscribers.forEach(subscriber -> subscriber.handleEvent(event.getType(), event.getContent()));
	}

	private List<ISubscriber> getSubscribers(String type) {
		return subscriptions.get(type);
		
	}

	private IEvent dequeueEvent() {
		try {
			return eventQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
