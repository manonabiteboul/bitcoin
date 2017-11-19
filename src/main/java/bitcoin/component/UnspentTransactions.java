package bitcoin.component;

import bitcoin.model.BlockchainOutput;
import bitcoin.model.Output;
import bitcoin.model.OutputsResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.json.simple.JSONObject;

import java.util.ArrayList;

@Component
public class UnspentTransactions {

    @Autowired
    private BlockchainRequest blockchainRequest;

    static Logger log = Logger.getLogger(UnspentTransactions.class.getName());

    public ResponseEntity<?> getUnspentTransactions(String address) {
        BlockchainOutput[] blockchainOutputs;
        try {
            blockchainOutputs = blockchainRequest.getTransactions(address);
        } catch (HttpServerErrorException e) {
            log.warn("error while fetching outputs for the following address from blockchain : " + address);
            JSONObject error = new JSONObject();
            error.put("error", "Error while fetching the transactions from blockchain : "+ e.getResponseBodyAsString());
            return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
        }
        log.info("fetched outputs for the following address from blockchain : " + address);
        return new ResponseEntity<Object>(buildOutputResponse(blockchainOutputs), HttpStatus.OK);
    }

    public static OutputsResponse buildOutputResponse(BlockchainOutput[] blockchainOutputs) {
        OutputsResponse outputs = OutputsResponse.builder().outputs(new ArrayList<Output>()).build();
        for(BlockchainOutput blockchainOutput : blockchainOutputs) {
            outputs.addOutput(Output.builder().value(blockchainOutput.getValue())
                    .txhash(blockchainOutput.getTx_hash())
                    .outputidk(blockchainOutput.getTx_output_n())
                    .build());
        }
        return outputs;
    }
}
