/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.processinstance.api.event;

import de.muenchen.demoservicempdz.processinstance.api.mapper.ProcessInstanceApiMapper;
import de.muenchen.demoservicempdz.processinstance.domain.service.ProcessInstanceService;
import de.muenchen.digitalwf.processinstance.domain.event.ProcessInstanceCreatedEvent;
import de.muenchen.digitalwf.processinstance.domain.event.ProcessInstanceStatusUpdateEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProcessInstanceEventConsumer {

    private final ProcessInstanceService processInstanceService;
    private final ProcessInstanceApiMapper processInstanceApiMapper;

    @JmsListener(destination = "processinstance.created", containerFactory = "jmsFactory")
    public void onProcessInstanceCreated(final ProcessInstanceCreatedEvent processInstanceCreatedEvent) {
        log.info("process instance created: " + processInstanceCreatedEvent.toString());

        this.processInstanceService.createProcessInstance(this.processInstanceApiMapper.mapProcessInstanceCreatedEvent(processInstanceCreatedEvent));
    }

    @JmsListener(destination = "processinstance.status", containerFactory = "jmsFactory")
    public void onProcessInstanceStatusUpdated(final ProcessInstanceStatusUpdateEvent processInstanceStatusUpdateEvent) {
        log.info("process instance statusUpdated: " + processInstanceStatusUpdateEvent.toString());

        this.processInstanceService.updateStatus(processInstanceStatusUpdateEvent.getStatusKey(), processInstanceStatusUpdateEvent.getProcessInstanceId());
    }

}
