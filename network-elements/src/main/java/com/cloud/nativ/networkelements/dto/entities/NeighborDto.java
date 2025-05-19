package com.cloud.nativ.networkelements.dto.entities;

import com.cloud.nativ.networkelements.utils.Defines;
import lombok.*;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 11:55 a.m.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NeighborDto implements Serializable {

    @Pattern(regexp = Defines.IP_REGEX, message = "Invalid Format")
    @EqualsAndHashCode.Include
    private String address;

    @NotBlank(message="Cost should not be blank !")
    @Digits(integer=10, fraction=0, message = "Cost value constraints : integer=10, fraction=0")
    private int cost;

}
