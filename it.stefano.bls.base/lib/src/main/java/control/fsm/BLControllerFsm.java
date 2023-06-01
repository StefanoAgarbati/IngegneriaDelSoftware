package control.fsm;

import interf.ILed;
import interfaces.IBLController;
import observable.GenericObserver;

public class BLControllerFsm extends GenericObserver implements IBLController {
	
	private IState curState;
	private ILed led;
	
	public BLControllerFsm(ILed aLed) {
		this.led = aLed;
		initFsm();
	}
	private void initFsm() {
		IState s0 = new S0State(led);
		IState sOn0 = new Son0State(led);
		IState sOn1 = new Son1State(led);
		IState sOff0 = new Soff0State(led);
		IState sOff1 = new Soff1State(led);
		
		s0.addTransition("pressed", sOn0);
		sOn0.addTransition("released", sOn1);
		sOn1.addTransition("pressed", sOff0);
		sOff0.addTransition("released", sOff1);
		sOff1.addTransition("pressed", sOn0);
		
		curState = s0;
		
	}
	
	@Override
	public void update(String data) {
		curState.update(data);
		updateState(data);
	}

	private void updateState(String input) {
		curState = curState.getNextState(input);
	}
	
	
}
