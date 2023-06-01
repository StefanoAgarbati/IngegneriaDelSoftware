package control.fsm1;

public interface IState {

	String getName();
	
	void executeActions(String input);
	
	void addAction(String input, IStateAction anAction);
	
}
