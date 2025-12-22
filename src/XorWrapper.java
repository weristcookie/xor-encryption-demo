class XorWrapper {
    public static String encrypt(String inputBits, String keyBits, Boolean verbose) { // bits -> bits
        String repeatedKeyBits = keyRepeater(inputBits, keyBits);
        String resultBits = XorUtil.xor(inputBits, repeatedKeyBits);

        if (verbose) {
            System.out.println("in:           " + inputBits);
            System.out.println("normal key:   " + keyBits);
            System.out.println("repeated key: " + repeatedKeyBits);
        }

        return resultBits;
    }

    public static String decrypt(String inputBits, String keyBits, Boolean verbose) { // bits -> bits
        String repeatedKeyBits = keyRepeater(inputBits, keyBits);

        String resultBits = XorUtil.xor(inputBits, repeatedKeyBits);

        if (verbose) {
            System.out.println("in:           " + inputBits);
            System.out.println("normal key:   " + keyBits);
            System.out.println("repeated key: " + repeatedKeyBits);
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
