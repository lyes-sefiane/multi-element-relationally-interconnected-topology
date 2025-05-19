package com.cloud.nativ.networkelements.domain.entities;

import com.cloud.nativ.networkelements.domain.enums.ElementType;
import com.cloud.nativ.networkelements.domain.enums.converter.ElementTypeConverter;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-23 10:23 a.m.
 */
@Entity
@Table(name = "network_device")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@OptimisticLocking(type = OptimisticLockType.ALL)
@DynamicUpdate
public class NetworkDevice implements Serializable {

    @Id
    @Column(name = "ipaddress")
    @EqualsAndHashCode.Include
    private String ipAddress;

    @Column(name = "element_type")
    @Convert(converter = ElementTypeConverter.class)
    private ElementType elementType;

    @Column(name = "area")
    private int area;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "networkDevice", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Connection> connections = new HashSet<>();

    /**
     * Override set Connection method
     *
     * Instead, to : this.connections = connections
     *
     * This will override the set that Hibernate is tracking & will throw an exception.
     *
     * org.hibernate.HibernateException: A collection with cascade="all-delete-orphan" was no longer referenced by the owning entity instance
     *
     * @param connections
     */
    public void setConnections(Set<Connection> connections) {
        this.getConnections().clear();
        if(connections != null) {
            this.getConnections().addAll(connections);
        }
    }

    @Override
    public String toString() {
        return "NetworkDevice{" +
                "ipAddress='" + ipAddress + '\'' +
                ", elementType=" + elementType +
                ", area=" + area +
                ", connections=" + connections +
                '}';
    }
}
