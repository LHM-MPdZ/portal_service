package de.muenchen.demoservicempdz.task.domain.event;

import de.muenchen.digitalwf.task.api.event.TaskCompletedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskEventPublisher {

    private final JmsTemplate jmsTemplate;

    public void sendTaskCompletedEvent(final TaskCompletedEvent event) {
        log.info("task completed event sent: " + event);

        this.jmsTemplate.convertAndSend("task.completed", event);
    }

}
