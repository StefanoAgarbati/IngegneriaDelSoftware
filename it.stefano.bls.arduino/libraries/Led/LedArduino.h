#ifndef LED_ARDUINO_H
#define LED_ARDUINO_H

#include "LedDevice.h"

class LedArduino : public LedDevice {
  public:
    LedArduino(int pin);
    // virtual void on();
    // virtual void off();
    // virtual bool isOn();
  protected:
    virtual void doOn();
    virtual void doOff();
  private:
    int pin;
};
#endif