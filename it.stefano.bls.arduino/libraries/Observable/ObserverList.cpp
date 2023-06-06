#include "ObserverList.h"

ObserverList::ObserverList(int maxSize) {
  this->maxSize = maxSize;
  this->observers = new Observer*[maxSize];
}
void ObserverList::addObserver(Observer* observer) {
  if(size < maxSize) {
    this->observers[size] = observer;
    size++; 
  }
}
void ObserverList::removeObserver(Observer * observer) {

}
Observer* ObserverList::getObserver(int pos) {
  if(pos >= 0 && pos < maxSize) {
    return this->observers[pos];
  } 
  return NULL;
}
int ObserverList::getSize() {
  return size;
}