public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Invalid usage!");
            return;
        }

        switch (args[0]) {
            case "-e" -> { // encrypt
                if (args.length < 3) {
                    System.out.println("Invalid usage!");
                    return;
                }

                String input = args[1]; // text
                String key = args[2]; // text
              
                Boolean verbose = args.length > 3 && args[3].equals("-v");
                
                String inputBits = BinaryConverter.convertToBin(input);
                String keyBits = BinaryConverter.convertToBin(key);

                String result = XorUtil.xor(inputBits, keyBits, verbose);

                System.out.println("out:          " + result);
            }
            case "-d" -> { // decrypt
                if (args.length < 3) {
                    System.out.println("Invalid usage!");
                    return;
                }

                String inputBits = args[1]; // binary
                String key = args[2]; // text

                Boolean verbose = args.length > 3 && args[3].equals("-v");

                String keyBits = BinaryConverter.convertToBin(key);
                String result = XorUtil.xor(inputBits, keyBits, verbose);
                String resultText = BinaryConverter.convertToText(result);

                System.out.println("out:          " + resultText);
            }
            case "-h" -> { // help
                System.out.println("Available commands:");
                System.out.println("-h: help");
                System.out.println("-e <text> <key>: encrypt");
                System.out.println("-d <encrypted text> <key>: decrypt");
                System.out.println("-v: verbose");
            }
        }
    }
}
