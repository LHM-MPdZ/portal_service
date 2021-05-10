package de.muenchen.demoservicempdz.task.domain.service;

import de.muenchen.demoservicempdz.shared.ObjectNotFoundException;
import de.muenchen.demoservicempdz.task.domain.event.TaskEventPublisher;
import de.muenchen.demoservicempdz.task.domain.mapper.TaskInfoMapper;
import de.muenchen.demoservicempdz.task.domain.model.TaskInfo;
import de.muenchen.demoservicempdz.task.domain.model.TaskStatus;
import de.muenchen.demoservicempdz.task.infrastructure.repository.TaskInfoRepository;
import de.muenchen.digitalwf.task.api.event.TaskCompletedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskInfoRepository taskInfoRepository;
    private final TaskInfoMapper taskInfoMapper;
    private final TaskEventPublisher taskEventPublisher;

    public void createTask(final TaskInfo taskInfo) {
        this.taskInfoRepository.save(this.taskInfoMapper.map(taskInfo));
    }

    public void deleteTask(final String taskId) {
        this.taskInfoRepository.deleteById(taskId);
    }

    public List<TaskInfo> getAllTasks(final String userId) {
        return this.taskInfoMapper.map(this.taskInfoRepository.findAll());
    }

    public List<TaskInfo> getAllTasksByProcessInstance(final String userId, final String processInstanceId) {
        return this.taskInfoMapper.map(this.taskInfoRepository.findAllByProcessInstanceId(processInstanceId));
    }

    public void completeTask(final String userId, final String taskId, final Map<String, String> data) {
        val task = this.getTask(taskId);
        task.setStatus(TaskStatus.PENDING);

        val taskCompletedEvent = TaskCompletedEvent.builder()
                .taskId(taskId)
                .data(data)
                .build();

        this.taskEventPublisher.sendTaskCompletedEvent(taskCompletedEvent);
        this.saveTask(task);
    }

    private TaskInfo saveTask(final TaskInfo taskInfo) {
        val savedTask = this.taskInfoRepository.save(this.taskInfoMapper.map(taskInfo));
        return this.taskInfoMapper.map(savedTask);
    }

    private TaskInfo getTask(final String taskId) {
        return this.taskInfoRepository.findById(taskId)
                .map(this.taskInfoMapper::map)
                .orElseThrow(() -> new ObjectNotFoundException(String.format("Task with id %s not availablke")));
    }

}
