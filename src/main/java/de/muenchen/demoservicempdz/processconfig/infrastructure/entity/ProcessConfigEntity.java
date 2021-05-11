/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.processconfig.infrastructure.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Entity object of the {@link de.muenchen.digitalwf.processconfig.domain.model.ProcessConfig}
 *
 * @author externer.dl.horn
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ProcessConfig")
@Table(name = "DWF_PROCESSCONFIG", indexes = { @Index(name = "IDX_DWF_PROCESSKEY", columnList = "KEY") })
public class ProcessConfigEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID", unique = true, nullable = false, length = 36)
    private String id;

    @Column(name = "KEY", nullable = false, unique = true)
    private String key;

    @Column(name = "VERSION", nullable = false)
    private String version;

    @Column(name = "CONFIG", columnDefinition = "CLOB")
    private String config;
}
