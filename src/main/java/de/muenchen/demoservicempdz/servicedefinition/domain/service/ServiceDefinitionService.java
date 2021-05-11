/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.servicedefinition.domain.service;

import de.muenchen.demoservicempdz.servicedefinition.domain.event.ServiceDefinitionEventPublisher;
import de.muenchen.demoservicempdz.servicedefinition.domain.model.ServiceDefinition;
import de.muenchen.digitalwf.processinstance.api.event.StartProcessInstanceEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service to interact with the {@link ServiceDefinition}
 *
 * @author externer.dl.horn
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceDefinitionService {

    private final ServiceDefinitionEventPublisher serviceDefinitionEventPublisher;

    /**
     * Start a service by key.
     *
     * @param key key of the service
     */
    public void startService(final String key, final Map<String, String> data) {
        val startProcessInstanceEvent = StartProcessInstanceEvent.builder()
                .processKey(key)
                .data(data)
                .build();
        this.serviceDefinitionEventPublisher.sendStartProcessInstanceEvent(startProcessInstanceEvent);
    }

}