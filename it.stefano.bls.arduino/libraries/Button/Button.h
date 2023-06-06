#ifndef BUTTON_H
#define BUTTON_H

#include "Observable.h"
#include "Observer.h"

class Button : public Observable, public Observer {
  public:
    virtual bool isPressed();
    virtual void update(String);
  protected:
    virtual void setState(bool);
    virtual bool getState();
  private:
    bool state = false;
};
#endif