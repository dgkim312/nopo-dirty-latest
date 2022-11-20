package com.tandem6.nopostore.starred.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Component
@Profile("!local")
public class SQSEventService implements EventService{

    @Autowired
    private SqsClient sqsClient;

    @Override
    public void publishEvent(Event event) {

        log.info("SQS");

        GetQueueUrlResponse queue = sqsClient.getQueueUrl(GetQueueUrlRequest.builder().queueName("nopo").build());

        SendMessageResponse sendMessageResponse = sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(queue.queueUrl())
                .messageBody(event.toString())
                .delaySeconds(1)
                .build());

        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queue.queueUrl())
                .maxNumberOfMessages(10)
                .build();
        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();

        for (Message message : messages) {
            final String body = message.body();
            log.info("Receive msg: {}", body);
            log.info("Delete msg: {}", body);
            DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                    .queueUrl(queue.queueUrl())
                    .receiptHandle(message.receiptHandle())
                    .build();
            sqsClient.deleteMessage(deleteMessageRequest);
        }
    }
}
