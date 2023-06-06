int buttonPin = 2;
int ledPin = 8;

int ton = 200;
int toff = 200;

boolean ledState = false; //turned off
boolean buttonState = false; // released
boolean prevButtonState = false;

//fsm states
int sOn = 0;
int sOff = 1;
int curState = sOff;

void initButton() {
  pinMode(buttonPin, INPUT);
}

void initLed() {
  pinMode(ledPin, OUTPUT);
}

void setup() {
  initButton();
  initLed();
  Serial.begin(115200);
  Serial.println("ButtonLedSystemLocalArduino");
}

void println(String msg) {
  Serial.println(msg);
}
void print(String msg) {
  Serial.print(msg);
}
void loop() {
  doJob();
}

boolean isOn() {
  return ledState;
}

void setLedState(boolean aState) {
  ledState = aState;
  //println("setLedState | ");
  updateLedState();
}

void ledOn() {
  digitalWrite(ledPin, HIGH);
  //println("ledOn | Led is turned on");
}

void ledOff() {
   digitalWrite(ledPin, LOW);
    //println("ledOff | Led is turned off");
}

void turnOnLed() {
  setLedState(true);
   //println("turnOnLed | set led state to true");
}

void turnOffLed() {
  setLedState(false);
  //println("turnOffLed | set led state to false");
}

void updateLedState() {
  if(ledState) {
    ledOn();
  } else {
    ledOff();
  }
}

void updateButtonState() {
  prevButtonState = buttonState;
  buttonState = readButtonState();
}

boolean readButtonState() {
  int state = digitalRead(buttonPin);
  //println("readButtonState | button state " + state);
  if(state==HIGH) {
    return true;
  }
  return false;
}

boolean isButtonReleased() {
  return prevButtonState == true && buttonState == false;
}

boolean isButtonPressed() {
  return prevButtonState == false && buttonState == true;
}

void waitFor(unsigned long time) {
  delay(time);
}

String fsm(String input) {
  String ledCmd = "";
  if(curState == sOn) {
    if(input.equals("pressed")) {
      ledCmd = "off";
      curState = sOff;
    }
  } else if(curState == sOff) {
    if(input.equals("pressed")) {
      ledCmd = "on";
      curState = sOn;
    }
  }
  return ledCmd;
}

void buttonLedControl() {
  updateButtonState();
  String input = isButtonPressed() ? "pressed" : "released";
  //println("buttonLedControl | input " + input);
  String cmd = fsm(input);
  processCmd(cmd);
}

void processCmd(String cmd) {
  if(cmd.equals("on")) {
    turnOnLed();
  } else if(cmd.equals("off")) {
    turnOffLed();
  }
}
void blinkTheLed() {
  turnOnLed();
  waitFor(ton);
  turnOffLed();
  waitFor(toff);
}

void doJob() {
  blinkTheLed();
  blinkTheLed();
  while(true) {
    buttonLedControl();
  }
}
