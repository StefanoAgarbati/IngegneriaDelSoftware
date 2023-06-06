#include "SerialPortSupportArduino.h"

char SerialPortSupportArduino::readAByte() {
  return (char)Serial.read();
}
String SerialPortSupportArduino::readAString() {
  String msg = Serial.readStringUntil('\n');
  Serial.println("message " + msg);
  return msg;
}
// String SerialPortSupportArduino::readAString() {
//   //while(Serial.available()) {}
//   String msg = "";
//   char cur = 'q';
//   while(cur != '\n') {
//     cur = (char)Serial.read();
//     //cur = readAByte();
//     if(cur != '\n')
//       msg = msg + String(cur);
//     //Serial.println("curmessage " + msg);
//   }
//   //Serial.println("readAString curmsg " + msg);
//   return msg;
// }

String SerialPortSupportArduino::readMsg() {
  String msg = readAString();
  //Serial.println("readAString " + msg);
  return msg;
}
void SerialPortSupportArduino::sendMsg(String msg) {
  Serial.println(msg);
}