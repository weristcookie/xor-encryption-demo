import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Invalid usage!");
            return;
        }

        switch (args[0]) {
            case "-e" -> { // encrypt
                String input = args[1]; // text
                String key = args[2]; // text

                byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
                String inputBits = "";

                for (byte b : inputBytes) {
                    inputBits += String.format("%8s", Integer.toBinaryString(b & 0xFF))
                            .replace(' ', '0');
                }

                byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
                String keyBits = "";

                for (byte b : keyBytes) {
                    keyBits += String.format("%8s", Integer.toBinaryString(b & 0xFF))
                            .replace(' ', '0');
                }

                String result = "";
                for (int i = 0; i < inputBits.length(); i++) {
                    if (inputBits.charAt(i) == keyBits.charAt(i)) {
                        result += "0";
                    } else {
                        result += "1";
                    }
                }

                System.out.println("in: " + inputBits);
                System.out.println("key: " + keyBits);
                System.out.println("out: " + result);
            }
            case "-d" -> { // decrypt
                String inputBits = args[1]; // binary
                String key = args[2]; // text

                byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
                String keyBits = "";

                for (byte b : keyBytes) {
                    keyBits += String.format("%8s", Integer.toBinaryString(b & 0xFF))
                            .replace(' ', '0');
                }

                String result = "";
                for (int i = 0; i < inputBits.length(); i++) {
                    if (inputBits.charAt(i) == keyBits.charAt(i)) {
                        result += "0";
                    } else {
                        result += "1";
                    }
                }
                
                byte[] bytes = new byte[result.length() / 8];

                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) Integer.parseInt(
                        result.substring(i * 8, i * 8 + 8), 2);
                }

                String text = new String(bytes, StandardCharsets.UTF_8);

                System.out.println("in: " + inputBits);
                System.out.println("key: " + keyBits);
                System.out.println("out: " + text);
            }
            case "-h" -> { // help
                System.out.println("Available commands:");
                System.out.println("-h: help");
                System.out.println("-e <text> <key>: encrypt");
                System.out.println("-d <encrypted text> <key>: decrypt");
            }
        }
    }
}
