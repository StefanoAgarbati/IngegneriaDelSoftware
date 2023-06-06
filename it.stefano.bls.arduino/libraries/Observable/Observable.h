#ifndef OBSERVABLE_H
#define OBSERVABLE_H

#include "Observer.h"
#include "ObserverList.h"

class Observable {
  public:
    Observable();
    virtual void addObserver(Observer*);
    virtual void removeObserver(Observer*);
  protected:
    virtual void updateObservers();
    virtual void setData(String);

  private:
    String data;
    ObserverList* observers;
};
#endif