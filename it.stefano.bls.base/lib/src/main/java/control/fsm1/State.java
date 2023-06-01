package control.fsm1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State implements IState {

	private String name;
	private Map<String, List<IStateAction>> actions = new HashMap<>();
	
	public State(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void addAction(String input, IStateAction anAction) {
		List<IStateAction> stateActions = actions.get(input);
		if(stateActions == null) {
			stateActions = new ArrayList<>();
			stateActions.add(anAction);
			actions.put(input, stateActions);
			return;
		}
		stateActions.add(anAction);
	}

	@Override
	public void executeActions(String input) {
		List<IStateAction> stateActions = actions.get(input);
		if(stateActions != null) {
			stateActions.stream().forEach(action -> action.execute());
		}
		
	}


}
