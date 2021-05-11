/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.processconfig.domain.mapper;

import com.google.gson.Gson;
import de.muenchen.demoservicempdz.processconfig.domain.model.ProcessConfig;
import de.muenchen.demoservicempdz.processconfig.infrastructure.entity.ProcessConfigEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Map between {@link ProcessConfigEntity} and {@link ProcessConfig}
 */
@Component
public class ProcessConfigMapper {

    public ProcessConfigEntity map2Entity(final ProcessConfig model) {
        return ProcessConfigEntity.builder()
                .key(model.getKey())
                .version("v1")
                .config(new Gson().toJson(model))
                .build();
    }

    public List<ProcessConfig> map(final List<ProcessConfigEntity> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

    public ProcessConfig map(final ProcessConfigEntity entity) {
        return new Gson().fromJson(entity.getConfig(), ProcessConfig.class);
    }
}
