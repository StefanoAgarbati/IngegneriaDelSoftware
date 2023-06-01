package blSystemAppl;

import blSystem.BLSystemConfig;
import interfaces.IApplication;
import mactor.impl.MActorContext;

public abstract class MainBaseActorSystem implements IApplication {

	public void startTheSystem() {
		configure();
		createComponents();
		activateComponents();
	}
	
	protected abstract void createComponents();
	
	protected void activateComponents() {
		MActorContext.activateActors();
	}
	protected void configure() {
		BLSystemConfig.setConfiguration();
	}
}
