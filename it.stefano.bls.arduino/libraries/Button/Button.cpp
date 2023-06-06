#include "Button.h"
#include <Arduino.h>

// Button::Button() {
//   Observable::Observable();
// }
bool Button::isPressed() {
  return this->state;
}
void Button::setState(bool state) {
  this->state = state;
  if(state) {
   setData(String("pressed"));
   //Serial.println("Button | set state pressed");
  } else {
    setData(String("released"));
  }
}
bool Button::getState() {
  return this->state;
}
void Button::update(String data) {
  //Serial.println("Button | update " + data);
  if(data.equals("pressed")) {
    setState(true);
  } else if(data.equals("released")) {
    setState(false);
  } 
}
