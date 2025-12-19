class XorUtil {
    public static String xor(String inputBits, String keyBits) {
        String result = "";
        
        for (int i = 0; i < inputBits.length(); i++) {
            if (inputBits.charAt(i) == keyBits.charAt(i)) {
                result += "0";
            } else {
                result += "1";
            }
        }

        return result;
    }
}
