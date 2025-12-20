class XorUtil {
    public static String xor(String inputBits, String keyBits) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < inputBits.length(); i++) {
            if (inputBits.charAt(i) == keyBits.charAt(i)) {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }

        return sb.toString();
    }
}
