package bitcoin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "unspent_outputs"
})
public class BlockchainResponse {
    @JsonProperty("unspent_outputs")
    private BlockchainOutput[] blockchainOutputs;

    public BlockchainOutput[] getBlockchainOutputs() {
        return blockchainOutputs;
    }
}
