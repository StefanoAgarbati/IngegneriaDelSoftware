#include "ButtonDeviceForSerialObserver.h"

ButtonDeviceForSerialObserver::ButtonDeviceForSerialObserver(SerialButton* button) {
  this->serialButton = button;
}
void ButtonDeviceForSerialObserver::update(String data) {
  serialButton->emit(data);
}
