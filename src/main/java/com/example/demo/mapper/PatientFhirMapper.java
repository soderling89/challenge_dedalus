package com.example.demo.mapper;

import com.example.demo.patient.Patient;
import org.hl7.fhir.r4.model.Identifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientFhirMapper {
    public Patient transformFromFhir(org.hl7.fhir.r4.model.Patient fhirPatient) {
        String nhc = getNHC(fhirPatient);

        Patient p = new Patient(fhirPatient.getIdElement().getIdPart(),
                nhc,
                fhirPatient.getName().get(0).getGivenAsSingleString(),
                fhirPatient.getName().get(0).getFamily(),
                fhirPatient.getBirthDate(),
                Patient.Gender.fromFhir(fhirPatient.getGender()));

        return p;
    }

    private String getNHC(org.hl7.fhir.r4.model.Patient fhirPatient) {

        Optional<Identifier> patientNhcIdentifier =
                fhirPatient.getIdentifier().stream().filter(identifier -> identifier.getValue() != null).findFirst();

        return patientNhcIdentifier.map(Identifier::getValue).orElse(null);

    }

}
