package com.example.demo.patient;

import lombok.*;
import org.hl7.fhir.r4.model.Enumerations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Patient {

    private String id;
    private String nhc;
    private String name;
    private String surname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private Gender gender;

    public Patient(String id, String nhc, String name, String surname, Date birthDate, Gender gender) {
        this.id = id;
        this.nhc = nhc;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public enum Gender {

        MALE("Masculino"),
        FEMALE("Femenino"),
        OTHER("Otro"),
        UNKNOWN("Desconocido");

        public static Gender fromFhir(Enumerations.AdministrativeGender fhirGender) {
            switch (fhirGender) {
                case FEMALE:
                    return Gender.FEMALE;
                case MALE:
                    return Gender.MALE;
                case OTHER:
                    return Gender.OTHER;
                case UNKNOWN:
                    return Gender.UNKNOWN;
                case NULL:
                default:
                    return null;
            }
        }


        private final String value;

        Gender(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

    }

}