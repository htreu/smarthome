/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.core.thing.firmware.dto;

/**
 * This is a data transfer object that is used to serialize firmware information.
 *
 * @author Aoun Bukhari - Initial contribution
 *
 */
public class FirmwareDTO {
    public String firmwareUID;
    public String vendor;
    public String model;
    public String description;
    public String version;
    public String changelog;
    public String prerequisiteVersion;

    /**
     * Default constructor for deserialization e.g. by Gson.
     */
    protected FirmwareDTO() {
    }

    public FirmwareDTO(String firmwareUID, String vendor, String model, String description, String version,
            String prerequisiteVersion, String changelog) {
        this.firmwareUID = firmwareUID;
        this.vendor = vendor;
        this.model = model;
        this.description = description;
        this.version = version;
        this.prerequisiteVersion = prerequisiteVersion;
        this.changelog = changelog;
    }
}
