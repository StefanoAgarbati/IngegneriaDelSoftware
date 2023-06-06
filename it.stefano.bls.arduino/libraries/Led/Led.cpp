#include "Led.h"
#include "LedDevice.h"

Led::Led(LedDevice* device) {
  this->device = device;
  this->off();
}
void Led::on() {
  this->state = true;
  this->device->on();
}
void Led::off() {
  this->state = false;
  device->off();
}
bool Led::isOn() {
  return state;
}
