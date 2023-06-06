#include "ButtonLedSystemArduino.h"
#include "LedArduino.h"
#include "ButtonArduino.h"

LedDevice* ButtonLedSystemArduino::createLedDevice(int pin) {
  return new LedArduino(pin);
}
ButtonDevice* ButtonLedSystemArduino::createButtonDevice(int pin) {
  return new ButtonArduino(pin);
}