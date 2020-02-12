#include <SPI.h>
#include <Ethernet.h>

char *fromArduino;

byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
IPAddress enderecoIP(192,168,1,200);
int serverPort = 80;
int led3 = 3;
int led4 = 4;
int led5 = 5;
int led6 = 6;
int led7 = 7;

EthernetServer server(serverPort);

void setup()
{
 Serial.begin(9600);
 Ethernet.begin(mac, enderecoIP);
 server.begin();
 Serial.print("Servidor online.");

 pinMode(led3, OUTPUT);
 pinMode(led4, OUTPUT);
 pinMode(led5, OUTPUT);
 pinMode(led6, OUTPUT);
 pinMode(led7, OUTPUT);
}

void loop()
{
 EthernetClient client = server.available();
 if (client) {

 while (client.connected()) {
if (client.available()) {


 char mensagem = client.read();

  Serial.print("Command: ");
  Serial.println(mensagem);

  if (mensagem == '1') {
   digitalWrite(led3, HIGH);
   Serial.println("Led status: 1 (ON)");
   client.println("Led status: 1 (ON)"); //aqui envia do arduino para o android
  }

  if (mensagem == '0') {
   digitalWrite(led3, LOW);
   Serial.println("Led status: 0 (OFF)");
   client.println("Led status: 0 (OFF)"); //aqui envia do arduino para o android
  }

  if (!client.connected()) {
   client.stop();
  }
 }
  }
 delay(1);
 client.stop();
 }
}
