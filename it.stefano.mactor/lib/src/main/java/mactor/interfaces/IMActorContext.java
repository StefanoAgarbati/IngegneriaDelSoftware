package mactor.interfaces;

import mactor.impl.MActor;
import mactor.impl.MessageSender;

public interface IMActorContext {

	void registerActor(String name, MActor actor);

	void deregisterActor(String name);

	MActor getActor(String name);

	void registerMessageSender(String name, MessageSender sender);

	MessageSender getMessageSender(String receiver);

}