/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.task.api.event;

import de.muenchen.demoservicempdz.task.api.mapper.TaskApiMapper;
import de.muenchen.demoservicempdz.task.domain.service.TaskService;
import de.muenchen.digitalwf.task.domain.event.TaskCreatedEvent;
import de.muenchen.digitalwf.task.domain.event.TaskRemovedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskEventConsumer {

    private final TaskService taskService;
    private final TaskApiMapper taskApiMapper;

    @JmsListener(destination = "task.created", containerFactory = "jmsFactory")
    public void onTaskCreated(final TaskCreatedEvent taskCreatedEvent) {
        log.info("task created " + taskCreatedEvent.toString());

        this.taskService.createTask(this.taskApiMapper.mapTaskCreatedEvent(taskCreatedEvent));
    }

    @JmsListener(destination = "task.removed", containerFactory = "jmsFactory")
    public void onTaskRemoved(final TaskRemovedEvent taskRemovedEvent) {
        log.info("task removed " + taskRemovedEvent.toString());

        this.taskService.deleteTask(taskRemovedEvent.getTaskId());
    }

}
