/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.processconfig.api.transport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * Transport object of the {@link de.muenchen.demoservicempdz.processconfig.domain.model.ProcessConfig}
 *
 * @author externer.dl.horn
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessConfigTO {

    /**
     * key of the process config.
     */
    @NotBlank
    private String key;

    /**
     * status config of the process definition.
     */
    @Builder.Default
    private List<StatusConfigTO> statusConfig = new ArrayList<>();

    /**
     * dynamic config entries.
     */
    @Builder.Default
    private List<ConfigEntryTO> configs = new ArrayList<>();
}
