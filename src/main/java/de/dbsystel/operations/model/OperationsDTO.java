package de.dbsystel.operations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Data-Transfer-Object for the operation infos
 */
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class OperationsDTO {

    @CsvBindByName(column = "Abk", required = true)
    @JsonIgnore
    private String code;

    @NonNull
    @Builder.Default
    @CsvBindByName(column = "Name", required = true)
    @JsonProperty("Name")
    private String name = "";

    @NonNull
    @Builder.Default
    @CsvBindByName(column = "Kurzname", required = true)
    @JsonProperty("Kurzname")
    private String shortName = "";

    @NonNull
    @Builder.Default
    @CsvBindByName(column = "Typ", required = true)
    @JsonProperty("Typ")
    private String type = "";

    @CsvBindByName(column = "Betr-Zust")
    @JsonIgnore
    private String status;

    @CsvBindByName(column = "Primary location code")
    @JsonIgnore
    private String primaryLocationCode;

    @CsvBindByName(column = "UIC")
    @JsonIgnore
    private String uic;

    @CsvBindByName(column = "RB")
    @JsonIgnore
    private String rb;

    @CsvBindByName(column = "gültig von")
    @JsonIgnore
    private String validFrom;

    @CsvBindByName(column = "gültig bis")
    @JsonIgnore
    private String validUntil;

    @CsvBindByName(column = "Netz-Key")
    @JsonIgnore
    private String networkKey;

    @CsvBindByName(column = "Fpl-rel")
    @JsonIgnore
    private String timetableRelevance;

    @CsvBindByName(column = "Fpl-Gr")
    @JsonIgnore
    private String timetableLimit;
}
