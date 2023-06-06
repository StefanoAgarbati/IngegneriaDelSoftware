#include "SerialButtonArduino.h"
#include "ButtonArduino.h"
#include "SerialPortSupportArduino.h"
#include "ButtonDeviceForSerialObserver.h"

SerialButtonArduino::SerialButtonArduino(int pin) {
  init(pin);
}
void SerialButtonArduino::init(int pin) {
  this->pin = pin;
  this->buttonDevice = new ButtonArduino(this->pin);
  this->serialSupport = new SerialPortSupportArduino();
  this->serialButton = new SerialButton(serialSupport);
  this->buttonObserver = new ButtonDeviceForSerialObserver(serialButton);

  buttonDevice->addObserver(buttonObserver);
}