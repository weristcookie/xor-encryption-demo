public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Invalid usage!");
            return;
        }

        switch (args[0]) {
            case "-e" -> { // encrypt
                if (args.length != 3) {
                    System.out.println("Invalid usage!");
                    return;
                }

                String input = args[1]; // text
                String key = args[2]; // text

                String result = XorWrapper.encrypt(input, key);
                System.out.println(result);
            }
            case "-d" -> { // decrypt
                if (args.length != 3) {
                    System.out.println("Invalid usage!");
                    return;
                }

                String inputBits = args[1]; // binary
                String key = args[2]; // text

                String result = XorWrapper.decrypt(inputBits, key);
                System.out.println(result);
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
