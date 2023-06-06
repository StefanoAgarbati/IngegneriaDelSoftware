#include "LedDevice.h"
#include <Arduino.h>

void LedDevice::on() {
  state = true;
  //Serial.println("LedDevice | on");
  doOn();
}
void LedDevice::off() {
  state = false;
  doOff();
}
bool LedDevice::isOn() {
  return state;
}