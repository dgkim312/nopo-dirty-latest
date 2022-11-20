package com.tandem6.nopostore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Profile("!local")
@Configuration
public class SqsConfig {

    @Bean
    public SqsClient sqsClient(SqsConfig sqsConfig) {
        SqsClient sqs = SqsClient.builder()
                .region(Region.of("ap-northeast-2"))
                .build();
        return sqs;
    }
}
