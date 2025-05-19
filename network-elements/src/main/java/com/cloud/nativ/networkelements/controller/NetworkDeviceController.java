package com.cloud.nativ.networkelements.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.nativ.networkelements.dto.entities.NetworkDeviceDto;
import com.cloud.nativ.networkelements.exception.entities.ExceptionResponse;
import com.cloud.nativ.networkelements.service.IService;
import com.cloud.nativ.networkelements.utils.Defines;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 1:55 p.m.
 */
@Validated
@RestController
@RequestMapping(value = "/v1/devices", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Network Device Controller")
@PropertySource("${springdoc.api-docs.messages}")
@CrossOrigin(origins = "http://localhost")
@ExposesResourceFor(NetworkDeviceDto.class)
public class NetworkDeviceController {

    private final IService<NetworkDeviceDto> networkDeviceService;

    @Autowired
    public NetworkDeviceController(IService<NetworkDeviceDto> networkDeviceService) {
        this.networkDeviceService = networkDeviceService;
    }

    @GetMapping
    @Operation(summary = "${findAllNetworkDevice}")
    @ApiResponse(responseCode = "200",
            description = "OK",
            content = @Content(schema = @Schema(implementation = NetworkDeviceDto.class)))
    public List<EntityModel<NetworkDeviceDto>> findAllNetworkDevice() {
        return toEntityModel(networkDeviceService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "${findById}")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = NetworkDeviceDto.class)))
    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "415", description = "UNSUPPORTED_MEDIA_TYPE", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public EntityModel<NetworkDeviceDto> findById(@PathVariable @Pattern(regexp = Defines.IP_REGEX, message = "Invalid Format") String id) {
        return toEntityModel(networkDeviceService.findById(id));
    }

    @PostMapping
    @Operation(summary = "${save}")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = NetworkDeviceDto.class)))
    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "422", description = "UNPROCESSABLE_ENTITY", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "415", description = "UNSUPPORTED_MEDIA_TYPE", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public EntityModel<NetworkDeviceDto> save(@RequestBody @Valid NetworkDeviceDto networkDeviceDto) {
        return toEntityModel(networkDeviceService.save(networkDeviceDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "${update}")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = NetworkDeviceDto.class)))
    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "422", description = "UNPROCESSABLE_ENTITY", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "415", description = "UNSUPPORTED_MEDIA_TYPE", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public EntityModel<NetworkDeviceDto> update(@RequestBody @Valid NetworkDeviceDto networkDeviceDto,
                                   @PathVariable @Pattern(regexp = Defines.IP_REGEX, message = "Invalid Format") String id) {
        return toEntityModel(networkDeviceService.update(networkDeviceDto, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "${delete}")
    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "415", description = "UNSUPPORTED_MEDIA_TYPE", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public void delete(@PathVariable @Pattern(regexp = Defines.IP_REGEX, message = "Invalid Format") String id) {
        networkDeviceService.delete(id);
    }

    // May be a better place/design for the following methods.
    // I love keep the controller as clean as possible with the exposed endpoints only !!
    // May be less trivial with the Redis Cache and the Serialization of the EnityModel è_é!!
    private List<EntityModel<NetworkDeviceDto>> toEntityModel(List<NetworkDeviceDto> networkDeviceDtoList) {
        return networkDeviceDtoList.stream().map(networkDeviceDto -> toEntityModel(networkDeviceDto)).collect(Collectors.toList());
    }

    private EntityModel<NetworkDeviceDto> toEntityModel(NetworkDeviceDto networkDeviceDto) {
        return EntityModel.of(networkDeviceDto)
                .add(linkTo(methodOn(NetworkDeviceController.class).findById(networkDeviceDto.getAddress())).withSelfRel());
    }
}
