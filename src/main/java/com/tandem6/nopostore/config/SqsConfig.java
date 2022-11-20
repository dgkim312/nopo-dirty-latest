package com.tandem6.nopostore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

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
