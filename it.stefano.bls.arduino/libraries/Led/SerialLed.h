#ifndef SERIAL_LED_H
#define SERIAL_LED_H

#include "LedDevice.h"
#include "SerialPortSupport.h"

class SerialLed {
  public:
    SerialLed();
    virtual void init();
    virtual void update();
  protected:
    virtual LedDevice* createLedDevice()=0;
    virtual SerialPortSupport* createSerialSupport()=0;
  private:
    LedDevice* device;
    SerialPortSupport* serialSupport;

    String readAMsg();
    void turnOnLed();
    void turnOffLed();
    void processMsg(String);
};
#endif