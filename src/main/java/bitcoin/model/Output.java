package bitcoin.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
@Data
public class Output {
    private int value;
    private String txhash;
    private int outputidk;
}


