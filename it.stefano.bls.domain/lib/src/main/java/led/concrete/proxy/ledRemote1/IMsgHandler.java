package led.concrete.proxy.ledRemote1;

import interfaces.IConnection;

public interface IMsgHandler {
	void handleMsg(String msg, IConnection conn);
}
