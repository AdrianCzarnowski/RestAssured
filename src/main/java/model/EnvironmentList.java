package model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class EnvironmentList {
    public EnvironmentModel prod;
    public EnvironmentModel init;

    public List<EnvironmentModel> getEnvironments() {
        List<EnvironmentModel> environments = new ArrayList<>();
        environments.add(getProd());
        environments.add(getInit());
        return environments;
    }
}
