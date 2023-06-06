#include "SerialLed.h"
#include <Arduino.h>

// SerialLed::SerialLed() {
//   this->device = createLedDevice();
//   this->serialSupport = createSerialSupport();
//   this->device->off();
// }
SerialLed::SerialLed() {
  //Serial.println("Serial");
  //init();
}
void SerialLed::init() {
  //Serial.println("init");
  this->device = createLedDevice();
  this->serialSupport = createSerialSupport();
  this->device->off();
  //Serial.println("init");
}
void SerialLed::turnOnLed() {
  device->on();
}
void SerialLed::turnOffLed() {
  device->off();
}

void SerialLed::processMsg(String msg) {
  Serial.println("processMsg " + msg);
  if(msg.equals("on")) {
    turnOnLed();
  } else if(msg.equals("off")) {
    turnOffLed();
  }
}
String SerialLed::readAMsg() {
  //Serial.println("SerialLed | readAMsg");
  String msg = serialSupport->readMsg();
  //Serial.println("SerialLed | message " + msg);
  return msg;
}
// SerialLed::SerialLed(LedDevice* device, SerialPortSupport* serialSupport) {
//   this->device = device;
//   this->serialSupport = serialSupport;
//   this->device->off();
// }
void SerialLed::update() {
  //Serial.println("SerialLed | update");
  String msg = readAMsg();
  processMsg(msg);
}

