package config;


import lombok.Data;
import lombok.NoArgsConstructor;
import model.EnvironmentList;


@Data
@NoArgsConstructor
public class Config {
    public EnvironmentList environment;
}
