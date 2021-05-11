package de.muenchen.demoservicempdz.servicedefinition.domain.event;

import de.muenchen.digitalwf.processinstance.api.event.StartProcessInstanceEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ServiceDefinitionEventPublisher {

    private final JmsTemplate jmsTemplate;

    public void sendStartProcessInstanceEvent(final StartProcessInstanceEvent event) {
        log.info("start service definition sent: " + event);

        this.jmsTemplate.convertAndSend("processinstance.start", event);
    }

}
