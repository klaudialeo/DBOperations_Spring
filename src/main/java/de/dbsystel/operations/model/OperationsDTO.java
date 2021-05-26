package de.dbsystel.operations.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Data-Transfer-Object for the operation infos
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationsDTO {

	@CsvBindByName(column = "Abk", required = true)
	@JsonIgnore
	private String code;

	@CsvBindByName(column = "Name", required = true)
	@JsonProperty("Name")
	private String name;

	@CsvBindByName(column = "Kurzname", required = true)
	@JsonProperty("Kurzname")
	private String shortName;

	@CsvBindByName(column = "Typ", required = true)
	@JsonProperty("Typ")
	private String type;

	@CsvBindByName(column = "Betr-Zust")
	@JsonIgnore
	private String status;

	@CsvBindByName(column = "Primary location code")
	@JsonIgnore
	private String primaryLocationCode;

	@CsvBindByName(column = "UIC")
	@JsonIgnore
	private int uic;

	@CsvBindByName(column = "RB")
	@JsonIgnore
	private int rb;

	@CsvDate(value = "yyyyMMdd")
	@CsvBindByName(column = "gültig von")
	@JsonIgnore
	private LocalDate validFrom;

	@CsvDate(value = "yyyyMMdd")
	@CsvBindByName(column = "gültig bis")
	@JsonIgnore
	private LocalDate validUntil;

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
