package com.tandem6.nopostore.config;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import com.amazonaws.xray.strategy.sampling.CentralizedSamplingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.ResourceUtils;

import javax.servlet.Filter;
import java.io.FileNotFoundException;
import java.net.URL;

@Slf4j
@Profile("dev")
@Configuration
public class WebConfig {
    private static final String SAMPLING_RULE_JSON = "classpath:/sampling-rules.json";

    static {

        URL ruleFile = null;
        try {
            ruleFile = ResourceUtils.getURL(SAMPLING_RULE_JSON);
        } catch (FileNotFoundException e) {
            log.error("sampling rule cannot load for aws xray - {}", e.getMessage());
        }
        log.debug("sampling rule load from {} for aws xray", ruleFile.getPath());

        AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard()
                .withDefaultPlugins()
                .withSamplingStrategy(new CentralizedSamplingStrategy(ruleFile));

        AWSXRay.setGlobalRecorder(builder.build());
        log.debug("aws xray recorder was setted globally.");
    }

    @Bean
    public Filter TracingFilter() {
        log.debug("The segment name for aws xray tracking has been set to {}.", "nopo");
        return new AWSXRayServletFilter("nopo");
    }
}

