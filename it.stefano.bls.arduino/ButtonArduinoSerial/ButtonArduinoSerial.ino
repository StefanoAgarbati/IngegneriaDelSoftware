#include "SerialButtonArduino.h"
#include "ButtonConfig.h"

SerialButtonArduino* button;

void setup() {
  Serial.begin(115200);
  initButton();
}
void initButton() {
  button = new SerialButtonArduino(ButtonConfig::pin);
}

void loop() {
}
