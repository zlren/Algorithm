package lab.zlren.leetcode.test.socket;

public class Test {

    public static void main(String[] args) {
        UDPClient udpClient = new UDPClient("localhost", 8888, "hello");
        udpClient.send();
        udpClient.send();
        udpClient.send();
    }
}
