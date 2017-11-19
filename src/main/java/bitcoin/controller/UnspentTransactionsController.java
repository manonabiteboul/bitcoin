package bitcoin.controller;

import bitcoin.common.DataConstants;
import bitcoin.component.UnspentTransactions;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
public class UnspentTransactionsController {

    @Inject
    UnspentTransactions unspentTransactions;

    @RequestMapping(method = RequestMethod.GET, path = DataConstants.ADDRESS_URL+"/{address}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public ResponseEntity<?> getCategoryToBrands(@PathVariable("address") String address) {
        return unspentTransactions.getUnspentTransactions(address);
    }

    @RequestMapping("*")
    @ResponseBody
    public ResponseEntity<?> fallbackMethod(){
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
}
