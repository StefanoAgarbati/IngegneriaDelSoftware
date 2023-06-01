package it.stefano.fsm;

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

	public void initialState(IState aState) {
		if(curState == null)
			curState = aState;
	}
	
	public void addState(String name) {
		if(!hasState(name)) {
			IState state = new State(name);
			addState(state);
		}
	}

	public boolean hasState(String name) {
		for(IState s : states) {
			if(s.getName().equals(name))
				return true;
		}
		return false;
	}

	public void addStateAction(String state, String input, IStateAction action) {
		for(IState s : states) {
			if(s.getName().equals(state))
				s.addAction(input, action);
		}
	}

	public void addTransition(String input, String curState, String nextState) {
		IState current = getState(curState);
		IState target = getState(nextState);
		if(current != null && target != null)
			addTransition(new Transition(input, current, target));
	}

	public void initialState(String name) {
		if(curState == null) {
			if(hasState(name)) {
				curState = getState(name);
			} else {
				addState(name);
			}
		}
			
	}
	
	private IState getState(String name) {
		for(IState s: states) {
			if(s.getName().equals(name))
				return s;
		}
		return null;
	}
}
