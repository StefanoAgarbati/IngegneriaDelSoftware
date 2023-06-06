#include "LedArduino.h"
#include <Arduino.h>

LedArduino::LedArduino(int pin) {
  this->pin = pin;
  pinMode(pin, OUTPUT);
  off();
}
void LedArduino::doOn() {
  digitalWrite(pin, HIGH);
}
void LedArduino::doOff() {
  digitalWrite(pin, LOW);
}