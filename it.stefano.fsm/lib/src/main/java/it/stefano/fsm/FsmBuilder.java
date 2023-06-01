package it.stefano.fsm;

public class FsmBuilder {

	private Fsm fsm;
	
	protected FsmBuilder() {
		fsm = new Fsm();
	}
	public FsmBuilder withInitialState(String name) {
		fsm.initialState(name);
		return this;
	}
	public FsmBuilder withState(String name) {
		IState state = new State(name);
		fsm.addState(state);
		return this;
	}
	public FsmBuilder withAction(String state, String input, IStateAction action) {
		fsm.addStateAction(state, input, action);
		return this;
	}
	public FsmBuilder withTransition(String input, String current, String target) {
		fsm.addTransition(input, current, target);
		return this;
	}
	public IFsm build() {
		return fsm;
	}
	public static FsmBuilder create() {
		return new FsmBuilder();
	}
}
