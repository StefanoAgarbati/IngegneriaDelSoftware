#ifndef OBSERVER_LIST_H
#define OBSERVER_LIST_H

#include "Observer.h"

class ObserverList {
  public:
    ObserverList(int maxSize);
    virtual void addObserver(Observer*);
    virtual void removeObserver(Observer*);
    virtual Observer* getObserver(int pos);
    virtual int getSize();
  private:
    int maxSize = 10;
    int size = 0;
    Observer** observers;
};

#endif