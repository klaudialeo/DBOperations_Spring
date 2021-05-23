package de.dbsystel.operations.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Data-Transfer-Object for the operation infos
 */
@Getter
@AllArgsConstructor
@Builder
public class OperationsDTO {

    @JsonProperty("Name")
    @Builder.Default
    private String name = "";

    @JsonProperty("Kurzname")
    @Builder.Default
    private String shortName = "";

    @JsonProperty("Typ")
    @Builder.Default
    private String type = "";
}
