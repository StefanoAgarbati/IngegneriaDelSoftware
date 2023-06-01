package it.stefano.fsm;

public class Transition implements ITransition {

	private IState current;
	private IState next;
	private String input;
	
	
	public Transition(String input,IState current, IState next) {
		this.current = current;
		this.next = next;
		this.input = input;
	}

	@Override
	public IState getNextState() {
		return next;
	}

	@Override
	public IState getCurrentState() {
		return current;
	}

	@Override
	public String getInput() {
		return input;
	}

}
