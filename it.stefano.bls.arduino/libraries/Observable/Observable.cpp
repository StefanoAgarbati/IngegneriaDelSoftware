#include "Observable.h"
#include<Arduino.h>

Observable::Observable() {
  this->observers = new ObserverList(10);
}
void Observable::addObserver(Observer* observer) {
  this->observers->addObserver(observer);
}
void Observable::removeObserver(Observer* observer) {
  this->observers->removeObserver(observer);
}
void Observable::setData(String data) {
  this->data = data;
  this->updateObservers();
  //Serial.println("Observable | setData " + data);
}
void Observable::updateObservers() {
  ObserverList* list = this->observers;
  for(int i = 0; i < list->getSize(); i++) {
    list->getObserver(i)->update(this->data);
  }
  //Serial.println("Observable | update observers");
}