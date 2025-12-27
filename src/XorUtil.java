class XorUtil {
    public static String xor(String inputBits, String keyBits, Boolean verbose) { // bits -> bits
        String repeatedKeyBits = keyRepeater(inputBits, keyBits);

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < inputBits.length(); i++) {
            if (inputBits.charAt(i) == repeatedKeyBits.charAt(i)) {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }

        String resultBits = sb.toString();

        if (verbose) {
            System.out.println("in:           " + inputBits);
            System.out.println("key:          " + keyBits);
            if (inputBits.length() != keyBits.length()) {
                System.out.println("repeated key: " + repeatedKeyBits);
            }
        }

        return resultBits;
    }

    private static String keyRepeater(String inputBits, String keyBits) {
        StringBuilder sb = new StringBuilder();

        int inputLength = inputBits.length();
        int keyLength = keyBits.length();

        int keyRepeat = inputLength / keyLength; // number of full key repeats
        int keyPart = inputLength % keyLength; // number of chars

        for (int i = 0; i < keyRepeat; i++) {
            sb.append(keyBits);
        }

        for (int i = 0; i < keyPart; i++) {
            sb.append(keyBits.charAt(i));
        }

        return sb.toString();
    }
}