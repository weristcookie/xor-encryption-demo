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

                String inputBits = BinaryConverter.convertToBin(input);
                String keyBits = BinaryConverter.convertToBin(key);

                String result = XorUtil.xor(inputBits, keyBits);

                System.out.println("in: " + inputBits);
                System.out.println("key: " + keyBits);
                System.out.println("out: " + result);
            }
            case "-d" -> { // decrypt
                String inputBits = args[1]; // binary
                String key = args[2]; // text

                String keyBits = BinaryConverter.convertToBin(key);
                String resultBits = XorUtil.xor(inputBits, keyBits);

                String result = BinaryConverter.convertToText(resultBits);

                System.out.println("in: " + inputBits);
                System.out.println("key: " + keyBits);
                System.out.println("out: " + result);
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
