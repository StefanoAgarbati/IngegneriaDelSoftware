#ifndef LED_H
#define LED_H

#include "LedDevice.h"

class Led {
  public:
    Led(LedDevice*);
    virtual void on();
    virtual void off();
    virtual bool isOn();
  private:
    bool state = false;
    LedDevice* device;
};
#endif