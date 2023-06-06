#include "ButtonDevice.h"

void ButtonDevice::setState(bool state) {
  this->state = state;
  if(state) {
   setData(String("pressed"));
   //Serial.println("Button | set state pressed");
  } else {
    setData(String("released"));
  }
}
bool ButtonDevice::getState() {
  return this->state;
}