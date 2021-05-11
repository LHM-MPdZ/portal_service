/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.processconfig.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for a specific process definition.
 *
 * @author externer.dl.horn
 */
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ProcessConfig {

    /**
     * key of the process config.
     */
    private String key;

    /**
     * status config of the process definition.
     */
    @Builder.Default
    private List<StatusConfig> statusConfig = new ArrayList<>();

    /**
     * dynamic config entries.
     */
    @Builder.Default
    private List<ConfigEntry> configs = new ArrayList<>();

    public String getStatus(final String statusKey) {
        return this.statusConfig.stream()
                .filter(config -> statusKey.equals(config.getKey()))
                .map(StatusConfig::getLabel)
                .findAny()
                .orElse(statusKey);
    }

    public String getConfig(final String configKey) {
        return this.configs.stream()
                .filter(obj -> configKey.equals(obj.getKey()))
                .map(ConfigEntry::getValue)
                .findFirst()
                .orElse(null);
    }

    public boolean isIgnoreFieldsOnStart() {
        return "1".equals(this.getConfig("ignore_fields_on_start"));
    }

}
