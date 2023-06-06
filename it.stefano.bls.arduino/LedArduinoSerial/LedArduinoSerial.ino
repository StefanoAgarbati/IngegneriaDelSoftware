#include "LedConfig.h"
#include "SerialLedArduino.h"


SerialLed* led;

void setup() {
  Serial.begin(115200);
  led = new SerialLedArduino(LedConfig::pin);
  led->init();
}
void loop() {
  led->update();
}
// void waitFor(unsigned long millis) {
//   delay(millis);
// }
