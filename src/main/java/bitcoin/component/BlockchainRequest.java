package bitcoin.component;

import bitcoin.BitcoinServiceApplication;
import bitcoin.common.DataConstants;
import bitcoin.model.BlockchainOutput;
import bitcoin.model.BlockchainResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Component
public class BlockchainRequest {
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
    }

    @Inject
    private BitcoinServiceApplication.BlockchainProperties blockchainProperties;

    public BlockchainOutput[] getTransactions(String address) {
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        BlockchainResponse response = restTemplate.exchange(blockchainProperties.getUri() + DataConstants.BLOCKCHAIN_UNSPENT_URL_ + address, HttpMethod.GET,
                getAuth(), BlockchainResponse.class).getBody();
        return response.getBlockchainOutputs();
    }

    private HttpEntity<String> getAuth() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> request = new HttpEntity<String>(headers);
        return request;
    }

}
