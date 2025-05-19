package com.cloud.nativ.networkelements.domain.entities;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-23 10:53 a.m.
 */
@Entity
@Table(name = "neighbor")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Neighbor {

    @Id
    @Column(name = "ipaddress")
    private String ipAddress;

}
