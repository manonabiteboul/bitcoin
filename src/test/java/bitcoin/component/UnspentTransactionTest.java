package bitcoin.component;

import bitcoin.model.BlockchainOutput;
import bitcoin.model.Output;
import bitcoin.model.OutputsResponse;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;

@Test
public class UnspentTransactionTest {
    @InjectMocks
    UnspentTransactions unspentTransactions;

    @Mock
    BlockchainRequest blockchainRequest;

    @BeforeMethod
    public void initTest() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(blockchainRequest.getTransactions("123")).thenReturn(buildBlockchainResponse());
        Mockito.when(blockchainRequest.getTransactions("456")).thenThrow(new HttpServerErrorException(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void testGetUnspentTransactions() {
        ResponseEntity<?> response = unspentTransactions.getUnspentTransactions("123");
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        ArrayList<Output> outputs = ((OutputsResponse)response.getBody()).getOutputs();
        Assert.assertEquals(outputs.size(), 3);
        Assert.assertEquals(outputs.get(0).getValue(), 0);
        Assert.assertEquals(outputs.get(1).getValue(), 10);
        Assert.assertEquals(outputs.get(2).getValue(), 20);

        ResponseEntity<?> responseError = unspentTransactions.getUnspentTransactions("456");
        Assert.assertEquals(responseError.getStatusCode(), HttpStatus.BAD_REQUEST);

    }

    @Test
    public void buildOutputResponseTest() {
        OutputsResponse emptyOutput = unspentTransactions.buildOutputResponse(new BlockchainOutput[]{});
        Assert.assertEquals(emptyOutput.getOutputs().size(),0);

        BlockchainOutput[] blockchainOutputs = buildBlockchainResponse();
        OutputsResponse outputs = unspentTransactions.buildOutputResponse(blockchainOutputs);
        Assert.assertEquals(outputs.getOutputs().size(),3);

        Assert.assertEquals(outputs.getOutputs().get(0).getValue(),0);
        Assert.assertEquals(outputs.getOutputs().get(0).getTxhash(),"0");
        Assert.assertEquals(outputs.getOutputs().get(0).getOutputidk(),0);

        Assert.assertEquals(outputs.getOutputs().get(1).getValue(),10);
        Assert.assertEquals(outputs.getOutputs().get(1).getTxhash(),"100");
        Assert.assertEquals(outputs.getOutputs().get(1).getOutputidk(),1);

        Assert.assertEquals(outputs.getOutputs().get(2).getValue(),20);
        Assert.assertEquals(outputs.getOutputs().get(2).getTxhash(),"200");
        Assert.assertEquals(outputs.getOutputs().get(2).getOutputidk(),2);

    }

    private BlockchainOutput[] buildBlockchainResponse() {
        BlockchainOutput[] blockchainOutputs = new BlockchainOutput[3];
        for(int i=0; i<3; i++) {
            BlockchainOutput blockchainOutput = new BlockchainOutput();
            blockchainOutput.setValue(10*i);
            blockchainOutput.setTx_output_n(i);
            blockchainOutput.setTx_hash(String.valueOf(i*100));
            blockchainOutputs[i] = blockchainOutput;
        }
        return blockchainOutputs;
    }

}
