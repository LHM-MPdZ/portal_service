package de.muenchen.demoservicempdz.processinstance.domain.service;

import de.muenchen.demoservicempdz.processinstance.domain.mapper.ProcessInstanceInfoMapper;
import de.muenchen.demoservicempdz.processinstance.domain.model.ProcessInstanceInfo;
import de.muenchen.demoservicempdz.processinstance.infrastructure.repository.ProcessInstanceInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessInstanceService {

    private final ProcessInstanceInfoRepository processInstanceInfoRepository;
    private final ProcessInstanceInfoMapper processInstanceInfoMapper;

    public void createProcessInstance(final ProcessInstanceInfo taskInfo) {
        this.processInstanceInfoRepository.save(this.processInstanceInfoMapper.map(taskInfo));
    }

    public List<ProcessInstanceInfo> getAllProcessInstances(final String userId) {
        return this.processInstanceInfoMapper.map(this.processInstanceInfoRepository.findAll());
    }

}
