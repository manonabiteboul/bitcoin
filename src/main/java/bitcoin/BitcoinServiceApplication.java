package bitcoin;

import lombok.Data;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableConfigurationProperties
@EnableWebMvc
public class BitcoinServiceApplication {

    public static void main(final String[] args) {
        new SpringApplicationBuilder().headless(true)
                .sources(BitcoinServiceApplication.class)
                .main(BitcoinServiceApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .registerShutdownHook(true)
                .run(args);
    }

    @Data
    @Component
    @ConfigurationProperties("blockchain")
    public static class BlockchainProperties {
        protected String uri;
    }

}
