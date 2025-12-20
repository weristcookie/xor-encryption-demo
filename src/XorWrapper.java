class XorWrapper {
    public static String encrypt(String input, String key) { // text -> bits
        String inputBits = BinaryConverter.convertToBin(input);
        String keyBits = BinaryConverter.convertToBin(key);

        String repeatedKeyBits = keyRepeater(inputBits, keyBits);
        String result = XorUtil.xor(inputBits, repeatedKeyBits);

        /*System.out.println("in: " + inputBits);
        System.out.println("key: " + repeatedKey);
        System.out.println("out: " + result);*/

        return result;
    }

    public static String decrypt(String inputBits, String key) { // bits -> text
        String keyBits = BinaryConverter.convertToBin(key);
        String repeatedKeyBits = keyRepeater(inputBits, keyBits);

        String resultBits = XorUtil.xor(inputBits, repeatedKeyBits);
        String result = BinaryConverter.convertToText(resultBits);

        /*System.out.println("in: " + inputBits);
        System.out.println("key: " + keyBits);
        System.out.println("out: " + result);*/

        return result;
    }

    private static String keyRepeater(String inputBits, String keyBits) {
        StringBuilder sb = new StringBuilder();

        int inputLength = inputBits.length();
        int keyLength = keyBits.length();

        //System.out.println("inputLength: " + inputLength + ", keyLength: " + keyLength);
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
