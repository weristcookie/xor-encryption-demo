class XorWrapper {
    public static String encrypt(String input, String key, Boolean verbose) { // text -> bits
        String inputBits = BinaryConverter.convertToBin(input);
        String keyBits = BinaryConverter.convertToBin(key);

        String repeatedKeyBits = keyRepeater(inputBits, keyBits);
        String result = XorUtil.xor(inputBits, repeatedKeyBits);

        if (verbose) {
            System.out.println("in:           " + inputBits);
            System.out.println("normal key:   " + keyBits);
            System.out.println("repeated key: " + repeatedKeyBits);
        }

        return result;
    }

    public static String decrypt(String inputBits, String key, Boolean verbose) { // bits -> text
        String keyBits = BinaryConverter.convertToBin(key);
        String repeatedKeyBits = keyRepeater(inputBits, keyBits);

        String resultBits = XorUtil.xor(inputBits, repeatedKeyBits);
        String result = BinaryConverter.convertToText(resultBits);

        if (verbose) {
            System.out.println("in:           " + inputBits);
            System.out.println("normal key:   " + keyBits);
            System.out.println("repeated key: " + repeatedKeyBits);
            System.out.println("result bits:  " + resultBits);
        }

        return result;
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
