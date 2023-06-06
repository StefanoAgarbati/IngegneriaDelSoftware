#include "SerialButton.h"

SerialButton::SerialButton(SerialPortSupport* support) {
  this->serialSupport = support;
}
void SerialButton::emit(String msg) {
  serialSupport->sendMsg(msg);
}