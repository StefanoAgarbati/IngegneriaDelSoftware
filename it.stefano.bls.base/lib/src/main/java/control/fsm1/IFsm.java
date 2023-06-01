package control.fsm1;

public interface IFsm {

	void update(String input);
	
	void addState(IState aState);
	
	void addTransition(ITransition aTransition);

	void initialState(IState aState);
	
}
