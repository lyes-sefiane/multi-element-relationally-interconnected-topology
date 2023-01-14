package com.cloud.nativ.networkelements.exception;

import com.cloud.nativ.networkelements.domain.entities.NetworkDevice;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-31 9:25 a.m.
 */
public class NetworkDeviceAlreadyExistsException extends RuntimeException {

    public NetworkDeviceAlreadyExistsException(NetworkDevice networkDevice) {
        super(networkDevice.getClass().getCanonicalName() + " with id " + networkDevice.getIpAddress() + " already exists");
    }

}
