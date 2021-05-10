import java.io.*;
import java.net.*;

class UDPClient {
   public static void main(String args[]) throws Exception {
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

      DatagramSocket clientSocket = new DatagramSocket();

      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];

      System.out.println("Calculadora complicada");
	  System.out.println("Digite um numero:");
      String sentence = inFromUser.readLine();
      sendData = sentence.getBytes();
	  DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
      clientSocket.send(sendPacket);
	  System.out.println("Um operador (+ - * /):");
	  String sentence = inFromUser.readLine();
      sendData = sentence.getBytes();
	  DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
      clientSocket.send(sendPacket);
	  System.out.println("Outro numero");
	  String sentence = inFromUser.readLine();
      sendData = sentence.getBytes();
	  DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
      clientSocket.send(sendPacket);
      
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      String resultado = new String(receivePacket.getData());

      System.out.println("Resultado:" + resultado);
      
      clientSocket.close();
   }
}