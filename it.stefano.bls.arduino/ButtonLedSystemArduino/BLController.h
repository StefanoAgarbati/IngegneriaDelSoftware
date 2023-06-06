#ifndef BL_CONTROLLER_H
#define BL_CONTROLLER_H

#include<Arduino.h>
#include "Led.h"
#include "Observer.h"

class BLController : public Observer {
  public:
    BLController(Led*);
    virtual void update(String data);
  private:
    Led* led;
    String state;

    virtual String fsm(String input);
    virtual void elab(String cmd);
    virtual void turnOnLed();
    virtual void turnOffLed();
};
#endif