#ifndef BUTTON_DEVICE_H
#define BUTTON_DEVICE_H

#include "Observable.h"

class ButtonDevice : public Observable {
  protected:
    virtual void setState(bool);
    virtual bool getState();
  private:
    bool state = false;
};
#endif