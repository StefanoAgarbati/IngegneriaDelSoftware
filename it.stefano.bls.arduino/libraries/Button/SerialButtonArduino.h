#ifndef SERIAL_BUTTON_ARDUINO_H
#define SERIAL_BUTTON_ARDUINO_H

#include "SerialPortSupport.h"
#include "Observer.h"
#include "ButtonDevice.h"
#include "SerialButton.h"

class SerialButtonArduino {
  public:
    SerialButtonArduino(int pin);
  private:
    void init(int pin);

    int pin;
    Observer* buttonObserver;
    ButtonDevice* buttonDevice;
    SerialButton* serialButton;
    SerialPortSupport* serialSupport;
};
#endif