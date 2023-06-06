#ifndef SERIAL_PORT_SUPPORT_H
#define SERIAL_PORT_SUPPORT_H

#include <Arduino.h>

class SerialPortSupport {
  public:
    virtual String readMsg() = 0;
    virtual void sendMsg(String msg) = 0;
};
#endif