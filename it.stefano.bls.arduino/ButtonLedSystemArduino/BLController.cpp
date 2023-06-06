#include "BLController.h"

String BLController::fsm(String input) {
  String cmd = "";
  if(input.equals("pressed")) {
    if(state.equals("sOff")) {
      cmd = "on";
      state = "sOn";
    } else if(state.equals("sOn")) {
      cmd = "off";
      state = "sOff";
    }
  }
  return cmd;
}
void BLController::elab(String cmd) {
  if(cmd.equals("on")) {
    turnOnLed();
  } else if(cmd.equals("off")) {
    turnOffLed();
  }
}
void BLController::turnOnLed() {
  led->on();
}
void BLController::turnOffLed() {
  led->off();
}

BLController::BLController(Led* led) {
  this->led = led;
  this->state = "sOff";
}
void BLController::update(String data) {
  //Serial.println("BLController | update " +data);
  String cmd = fsm(data);
  elab(cmd);
}