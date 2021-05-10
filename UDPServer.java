import java.io.*;
import java.net.*;

class UDPServer {
   public static void main(String args[]) throws Exception {
      
      DatagramSocket serverSocket = new DatagramSocket(9876);

      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];
      while (true) {

         System.out.println("\nEscutando... ");

         DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket);
         double numero1 = new String(receivePacket.getData());
		 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket);
         String operador = new String(receivePacket.getData());
		 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket);
         double numero2 = new String(receivePacket.getData());
		 
         System.out.println("Recebido: " + numero1 + operador + numero2);
         InetAddress IPAddress = receivePacket.getAddress();
         int port = receivePacket.getPort();

		double resultado = 0;
		String erro;
		 if (operador == '+'){
			resultado = numero1 + numero2;
		 } else {
			 if (operador == '-'){
				 resultado = numero1 - numero2;
			 } else {
				 if (operador == '*'){
					resultado = numero1 * numero2; 
				 } else {
					 if (operador == '/' && numero2 != 0){
						 resultado = numero1 / numero2;
					 } else {
						erro == "Não divisivel por zero!"
						sendData = capitalizedSentence.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

						serverSocket.send(sendPacket);
		 
					 }
				 }
			 }
		 }
         
         sendData = resultado.getBytes();
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

         serverSocket.send(sendPacket);
      }
   }
}