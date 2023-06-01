package control.fsm1;

import interf.ILed;
import interfaces.IBLController;
import observable.GenericObserver;

public class BLControllerFsm extends GenericObserver implements IBLController {
	
	private IState curState;
	private ILed led;
	private IFsm fsm;
	
	public BLControllerFsm(ILed aLed) {
		this.led = aLed;
		initFsm();
	}
	private void initFsm() {
		fsm = new Fsm();
		
		IState s0 = new State("s0");
		IState sOn0 = new State("sOn0");
		IState sOn1 = new State("sOn1");
		IState sOff0 = new State("sOff0");
		IState sOff1 = new State("sOff1");
		
		ITransition t0 = new Transition("pressed", s0, sOn0);
		ITransition t1 = new Transition("released", sOn0, sOn1);
		ITransition t2 = new Transition("pressed", sOn1, sOff0);
		ITransition t3 = new Transition("released", sOff0, sOff1);
		ITransition t4 = new Transition("pressed", sOff1, sOn0);
		
		BLFsmActions actions = new BLFsmActions(led);
		
		s0.addAction("pressed", () -> actions.execute("on"));
		sOn1.addAction("pressed", () -> actions.execute("off"));
		sOff1.addAction("pressed", () -> actions.execute("on"));
		
		fsm.addState(s0);
		fsm.addState(sOn0);
		fsm.addState(sOn1);
		fsm.addState(sOff0);
		fsm.addState(sOff1);
		
		fsm.addTransition(t0);
		fsm.addTransition(t1);
		fsm.addTransition(t2);
		fsm.addTransition(t3);
		fsm.addTransition(t4);
		
		fsm.initialState(s0);
		
	}
	
	@Override
	public void update(String data) {
		fsm.update(data);
	}
	
}
