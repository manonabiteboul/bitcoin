package bitcoin.component;

import java.math.BigInteger;

public class DecodeTxHash {

    public static String decode(String txHash) {
        return binToHex(reverseBinary(hexToBin(txHash)));
    }

    public static String hexToBin(String hex) {
        return new BigInteger(hex, 16).toString(2);
    }

    public static String binToHex(String binary) {
        return new BigInteger(binary, 2).toString(16);
    }

    public static String reverseBinary(String binary) {
        String reversed = "";
        int i = binary.length()-8;
        while ( i>=0 ) {
            reversed += binary.substring(i, i+8);
            i-=8;
        }
        return reversed;
    }
}
