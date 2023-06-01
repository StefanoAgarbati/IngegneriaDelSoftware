package it.stefano.fsm;

public interface IState {

	String getName();
	
	void executeActions(String input);
	
	void addAction(String input, IStateAction anAction);
	
}
