#ifndef SERIAL_PORT_SUPPORT_ARDUINO_H
#define SERIAL_PORT_SUPPORT_ARDUINO_H

#include "SerialPortSupport.h"

class SerialPortSupportArduino: public SerialPortSupport {
  public:
    virtual String readMsg();
    virtual void sendMsg(String msg);
  private:
    char readAByte();
    String readAString();
};
#endif