package bitcoin.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;

@Builder
@Getter
@Data
public class OutputsResponse {
    private ArrayList<Output> outputs;

    public ArrayList<Output> getOutputs() {
        return outputs;
    }

    public void addOutput(Output output) {
        if(outputs == null) {
            outputs = new ArrayList<Output>();
        }
        outputs.add(output);
    }
}