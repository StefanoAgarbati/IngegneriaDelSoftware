package control.fsm1;

public interface ITransition {
	
	IState getNextState();
	
	IState getCurrentState();
	
	String getInput();
	
}
