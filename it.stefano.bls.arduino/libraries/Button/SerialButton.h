#ifndef SERIAL_BUTTON_H
#define SERIAL_BUTTON_H

#include <Arduino.h>
#include "SerialPortSupport.h"

class SerialButton {
  public:
    SerialButton(SerialPortSupport* support);
    virtual void emit(String msg);
  private:
    SerialPortSupport* serialSupport;
};
#endif