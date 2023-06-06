#ifndef SERIAL_LED_ARDUINO_H
#define SERIAL_LED_ARDUINO_H

#include "SerialLed.h"
#include "LedDevice.h"
#include "SerialPortSupport.h"

class SerialLedArduino : public SerialLed {
  public:
    SerialLedArduino(int pin);
  protected:
    virtual LedDevice* createLedDevice();
    virtual SerialPortSupport* createSerialSupport();
  private:
    int pin;
};
#endif
