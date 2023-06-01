package control.fsm;

public interface IState {

	void update(String input);
	
	void addTransition(String input, IState next);
	
	IState getNextState(String input);
	
}
