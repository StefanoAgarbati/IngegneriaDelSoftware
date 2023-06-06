#ifndef LED_DEVICE_H
#define LED_DEVICE_H

class LedDevice {
  public:
    virtual void on();
    virtual void off();
    virtual bool isOn();
  protected:
    virtual void doOn();
    virtual void doOff();
  private:
    bool state = false;
};
#endif