#include<SPI.h>
#include<Ethernet.h>
        byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED};
        byte ip[] = {10,50, 187, 72};
        //10.50.187.71

        int led3 = 3;
        int led4 = 4;
        int led5 = 5;
        int led6 = 6;
        int led7 = 7;
        EthernetServer server = EthernetServer(8080);
        void setup(){
            Serial.begin(9600);
            Ethernet.begin(mac, ip);

            server.begin();
            Serial.println("Servidor Ativo");
            Serial.print("Meu endereço ip: ");
            Serial.println(Ethernet.localIP());

            pinMode(led3, OUTPUT);
            pinMode(led4, OUTPUT);
            pinMode(led5, OUTPUT);
            pinMode(led6, OUTPUT);
            pinMode(led7, OUTPUT);
        }

        void loop(){
          EthernetClient cliente = server.available();
            if (cliente) {
                while (cliente.connected()) {
                    while (cliente.available() > 0) {
                        char mensagem = cliente.read();
                        Serial.write(mensagem);

                        if (mensagem == '1') {
                            digitalWrite(led3, HIGH);
                            Serial.println("Led status: 1 (ON)");
                            cliente.println("Led status: 1 (ON)"); //aqui envia do arduino para o android
                        }
                        if (mensagem == '0') {
                            digitalWrite(led3, LOW);
                            Serial.println("Led status: 0 (OFF)");
                            cliente.println("Led status: 0 (OFF)"); //aqui envia do arduino para o android
                        }
                        if(mensagem == "2"){
                          digitalWrite(led4, HIGH);
                            Serial.println("Led status: 0 (OFF)");
                            cliente.println("Led status: 0 (OFF)"); //aqui envia do arduino para o android
                        }
                        if(mensagem == "3"){
                          digitalWrite(led4, LOW);
                            Serial.println("Led status: 0 (OFF)");
                            cliente.println("Led status: 0 (OFF)"); //aqui envia do arduino para o android
                        }
                        if (!cliente.connected()) {
                            cliente.stop();
                        }
                    }
                }
                delay(10);
                cliente.stop();
                Serial.println("Cliente Desconectado");
            }
        }
