package bitcoin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "tx_hash",
        "tx_hash_big_endian",
        "tx_index",
        "tx_output_n",
        "script",
        "value",
        "value_hex",
        "confirmations",
})
public class BlockchainOutput {
    @JsonProperty("tx_hash")
    private String tx_hash;

    @JsonProperty("tx_hash_big_endian")
    private String tx_hash_big_endian;

    @JsonProperty("tx_index")
    private int tx_index;

    @JsonProperty("tx_output_n")
    private  int tx_output_n;

    @JsonProperty("script")
    private String script;

    @JsonProperty("value")
    private int value;

    @JsonProperty("value_hex")
    private String value_hex;

    @JsonProperty("confirmations")
    private int confirmations;

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getTx_hash() {
        return this.tx_hash;
    }

    public void setTx_hash(String tx_hash) {
        this.tx_hash = tx_hash;
    }

    public int getTx_output_n() {
        return this.tx_output_n;
    }

    public void setTx_output_n(int tx_output_n) {
        this.tx_output_n = tx_output_n;
    }
}