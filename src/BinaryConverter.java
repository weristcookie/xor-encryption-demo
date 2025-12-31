import java.nio.charset.StandardCharsets;

class BinaryConverter {
    public static String convertToBin(String input) { // text -> bin
        StringBuilder sb = new StringBuilder();

        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8); // convert string to bytes
        
        for (byte b : inputBytes) {
            int unsignedByte = b & 0xFF; // treat byte as unsigned (0-255)
            String binary = Integer.toBinaryString(unsignedByte); // convert to binary
            String padded = String.format("%8s", binary); // pad to 8 chars
            String eightBits = padded.replace(' ', '0'); // replace spaces with zeros
            sb.append(eightBits); // append 8-bit binary
        }

        return sb.toString();
    }

    public static String convertToText(String input) { // bin -> text
        byte[] bytes = new byte[input.length() / 8]; // create byte array, 8 bits per byte

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(input.substring(i * 8, i * 8 + 8), 2);
            // take 8 bits from input, cast to a byte and insert into array
        }

        String result = new String(bytes, StandardCharsets.UTF_8); // convert byte array to readable text using utf-8

        return result;
    }
}
