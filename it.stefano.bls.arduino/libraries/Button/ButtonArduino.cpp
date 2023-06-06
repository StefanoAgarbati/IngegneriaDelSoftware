#include "ButtonArduino.h"
#include<Arduino.h>

int readInputFrom(int pin) {
  return digitalRead(pin);
}
bool debounce(int time, int pin) {
  int current = readInputFrom(pin);
  delay(time);
  int prev = current;
  current = readInputFrom(pin);
  if(current == prev)
    return true;
  return false;
}

ButtonArduino* ButtonArduino::instance = NULL;

ButtonArduino::ButtonArduino(int pin) {
  instance = this;
  this->pin = pin;
  pinMode(this->pin, INPUT);
  attachInterrupt(digitalPinToInterrupt(pin), handleInterrupt, CHANGE);
}
ButtonArduino* ButtonArduino::getInstance(int pin) {
  if(ButtonArduino::instance == NULL) {
    instance = new ButtonArduino(pin);
  }
  return instance;
}
void ButtonArduino::handleInput() {
  if(debounce(20,this->pin)) {
    //Serial.println("debounce ok");
    int current = digitalRead(this->pin);
    if(this->getState() && !current) {
      //Serial.println("button is released");
      setState(false);
    } else if(!this->getState() && current) {
      //Serial.println("button is pressed");
      setState(true); //released
    }
  }
}
void ButtonArduino::handleInterrupt() {
  instance->handleInput();
}


