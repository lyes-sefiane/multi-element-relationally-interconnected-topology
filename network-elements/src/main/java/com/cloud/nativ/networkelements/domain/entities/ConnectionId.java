package com.cloud.nativ.networkelements.domain.entities;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-24 12:06 p.m.
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ConnectionId implements Serializable {

    @Column(name = "network_device_ipaddress")
    private String network_device_ipaddress;

    @Column(name = "neighbor_ipaddress")
    private String neighbor_ipaddress;

}
