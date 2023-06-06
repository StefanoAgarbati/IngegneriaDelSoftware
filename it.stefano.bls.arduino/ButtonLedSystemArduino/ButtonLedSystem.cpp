#include "ButtonLedSystem.h"
#include "ButtonLedSystemConfig.h"

void ButtonLedSystem::createTheSystem() {
  createComponents();
  connectsComponents();
}
void ButtonLedSystem::createComponents() {
  this->ledDevice = createLedDevice(ButtonLedSystemConfig::ledPin);
  this->led = new Led(ledDevice);
  this->button = new Button();
  this->buttonDevice = createButtonDevice(ButtonLedSystemConfig::buttonPin);
  this->controller = new BLController(led);
}
void ButtonLedSystem::connectsComponents() {
  this->button->addObserver(this->controller);
  this->buttonDevice->addObserver(this->button);
}