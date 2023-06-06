#ifndef BLS_H
#define BLS_H

#include "LedDevice.h"
#include "Observable.h"
#include "Button.h"
#include "ButtonDevice.h"
#include "Led.h"
#include "LedDevice.h"
#include "Observer.h"
#include "BLController.h"

class ButtonLedSystem {
  public:
    virtual void createTheSystem();
  protected:
    virtual LedDevice* createLedDevice(int) = 0;
    virtual ButtonDevice* createButtonDevice(int) = 0;
  private:
    virtual void createComponents();
    virtual void connectsComponents();

    Button* button;
    ButtonDevice* buttonDevice;
    Led* led;
    LedDevice* ledDevice;
    Observer* controller;
};
#endif