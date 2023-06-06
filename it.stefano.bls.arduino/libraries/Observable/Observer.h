#ifndef OBSERVER_H
#define OBSERVER_H
#include<Arduino.h>

class Observer {
  public:
    virtual void update(String data) = 0;
};
#endif