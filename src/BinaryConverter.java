import java.nio.charset.StandardCharsets;

class BinaryConverter {
    public static String convertToBin(String input) {
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        String result = "";

        for (byte b : inputBytes) {
            result += String.format("%8s", Integer.toBinaryString(b & 0xFF))
                    .replace(' ', '0');
        }

        return result;
    }

    public static String convertToText(String input) {
        byte[] bytes = new byte[input.length() / 8];

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(
                input.substring(i * 8, i * 8 + 8), 2);
        }

        String result = new String(bytes, StandardCharsets.UTF_8);

        return result;
    }
}
