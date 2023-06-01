package it.stefano.fsm;

public interface ITransition {
	
	IState getNextState();
	
	IState getCurrentState();
	
	String getInput();
	
}
