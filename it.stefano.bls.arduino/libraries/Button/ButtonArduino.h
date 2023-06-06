#ifndef BUTTON_ARDUINO_H
#define BUTTON_ARDUINO_H

#include "ButtonDevice.h"

class ButtonArduino : public ButtonDevice {
  public:
    //static ButtonArduino* instance;
    ButtonArduino(int pin);
    static ButtonArduino* getInstance(int);
  protected:
    //static ButtonArduino* instance;
  private:
    int pin;
    static ButtonArduino* instance;
    virtual void handleInput();
    static void handleInterrupt();
};
#endif