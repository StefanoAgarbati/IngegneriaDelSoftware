#ifndef BUTTON_DEVICE_FOR_SERIAL_OBSERVER_H
#define BUTTON_DEVICE_FOR_SERIAL_OBSERVER_H

#include <Arduino.h>
#include "Observer.h"
#include "SerialButton.h"

class ButtonDeviceForSerialObserver : public Observer {
  public:
    ButtonDeviceForSerialObserver(SerialButton* serialButton);
    virtual void update(String data);
  private:
    SerialButton* serialButton;
};
#endif