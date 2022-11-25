package com.tandem6.nopostore.starred.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.List;

@Slf4j
@Component
@Profile("dev")
public class SQSEventService implements EventService{

    @Autowired
    private SqsClient sqsClient;

    @Override
    public void publishEvent(Event event) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        GetQueueUrlResponse queue = sqsClient.getQueueUrl(GetQueueUrlRequest.builder().queueName("NopoServerlessStack-StarQueue73294539-iKMBf8gNGNt2").build());

        SendMessageResponse sendMessageResponse = sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(queue.queueUrl())
                .messageBody(mapper.writeValueAsString(event))
                .delaySeconds(1)
                .build());

        //Read Event from SQS
//        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
//                .queueUrl(queue.queueUrl())
//                .maxNumberOfMessages(10)
//                .build();
//        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();
//
//        for (Message message : messages) {
//            final String body = message.body();
//            log.info("Receive msg: {}", body);
//            log.info("Delete msg: {}", body);
//            DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
//                    .queueUrl(queue.queueUrl())
//                    .receiptHandle(message.receiptHandle())
//                    .build();
//            sqsClient.deleteMessage(deleteMessageRequest);
//        }
    }
}
