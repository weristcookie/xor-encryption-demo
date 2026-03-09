# xor-encryption-demo

## About this demo

This is a simple Java program demonstrating XOR encryption in a way that is easy to understand. The code is intentionally written for clarity, not efficiency.

## How XOR encryption works

XOR encryption combines each bit of your input with a corresponding bit from a key using the XOR operation.  
If you apply the same key again to the encrypted output, you get back the original text.

### Encryption steps

1. Convert text and key to binary (UTF-8 enconding)
2. Repeat the key if it is shorter than the input
3. XOR each bit of the input with the key
4. Output the resulting encrypted binary


### Decryption steps

1. Convert the key to binary
2. Repeat the key if needed
3. XOR each bit of the encrypted input with the key
4. Convert the resulting binary back to text
5. Output the text

## Usage

```sh
# Encrypt text
java Main -e "hello" "key"

# Decrypt binary output
java Main -d <binary_output> "key"

# Verbose mode
java Main -e "hello" "key" -v```