package bitcoin.component;


import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class DecodeTxHashTest {

    String hex1 = "e";
    String bin1 = "1110";

    String hex2 = "e6452a2cb";
    String bin2 = "111001100100010100101010001011001011";

    String txhash = "d7616a765a659ba47a39ad4afab710555492452b435cd0c10a84744b116cdff3";
    String txhashDecoded = "f3df6c114b74840ac1d05c432b4592545510b7fa4aad397aa49b655a766a61d7";

    @Test
    public void testDecode() {
        Assert.assertEquals(DecodeTxHash.decode(txhash), txhashDecoded);
    }

    @Test
    public void hexToBinTest() {
        Assert.assertEquals(DecodeTxHash.hexToBin(hex1), bin1);
        Assert.assertEquals(DecodeTxHash.hexToBin(hex2), bin2);
    }

    @Test
    public void binToHexTest() {
        Assert.assertEquals(DecodeTxHash.binToHex(bin1), hex1);
        Assert.assertEquals(DecodeTxHash.binToHex(bin2), hex2);
    }

    @Test
    public void reverseBinaryTest() {
        Assert.assertEquals(DecodeTxHash.reverseBinary(""), "");
        Assert.assertEquals(DecodeTxHash.reverseBinary("11001010"), "11001010");
        Assert.assertEquals(DecodeTxHash.reverseBinary("1100101011100010"), "1110001011001010");
        Assert.assertEquals(DecodeTxHash.reverseBinary("11111111000000001111111100000000"), "00000000111111110000000011111111");
    }
}
