#include "ButtonLedSystem.h"
#include "ButtonLedSystemArduino.h"

ButtonLedSystem* blSystem;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  createSystem();
}

void createSystem() {
  blSystem = new ButtonLedSystemArduino();
  blSystem->createTheSystem();
}

void loop() {
  
}
