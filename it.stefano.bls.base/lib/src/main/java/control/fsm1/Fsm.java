package control.fsm1;

import java.util.ArrayList;
import java.util.List;

public class Fsm implements IFsm {

	private IState curState;
	private List<IState> states = new ArrayList<>();
	private List<ITransition> transitions = new ArrayList<>();
	
	public void update(String input) {
		curState.executeActions(input);
		curState = getNextState(input, curState);
	}
	
	private IState getNextState(String input, IState curState) {
		ITransition transition = getTransition(input, curState);
		if(transition == null) {
			return curState;
		}
		return transition.getNextState();
	}

	private ITransition getTransition(String input, IState curState) {
		for(ITransition t : transitions) {
			if(input.equals(t.getInput()) && 
					t.getCurrentState().getName().equals(curState.getName()))
				return t;
		}
		return null;
	}

	public void addState(IState aState) {
		states.add(aState);
	}
	
	public void addTransition(ITransition aTransition) {
		transitions.add(aTransition);
	}

	@Override
	public void initialState(IState aState) {
		if(curState == null)
			curState = aState;
	}
}
