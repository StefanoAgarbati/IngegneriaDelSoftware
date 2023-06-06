#ifndef BLS_ARDUINO_H
#define BLS_ARDUINO_H

#include "ButtonLedSystem.h"
#include "LedDevice.h"
#include "ButtonDevice.h"

class ButtonLedSystemArduino : public ButtonLedSystem {
  protected:
    virtual LedDevice* createLedDevice(int);
    virtual ButtonDevice* createButtonDevice(int);
};
#endif