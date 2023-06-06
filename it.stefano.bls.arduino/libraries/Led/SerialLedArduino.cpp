#include "SerialLedArduino.h"
#include "LedArduino.h"
#include "SerialPortSupportArduino.h"

SerialLedArduino::SerialLedArduino(int pin) : SerialLed() {
  this->pin = pin;
  //Serial.println("SerialLedArduino | created on pin " + String(pin));
}
LedDevice* SerialLedArduino::createLedDevice() {
  //Serial.println("creation");
  return new LedArduino(this->pin);
}
SerialPortSupport* SerialLedArduino::createSerialSupport() {
  //Serial.println("SerialLedArduino | serial support creation");
  return new SerialPortSupportArduino();
}