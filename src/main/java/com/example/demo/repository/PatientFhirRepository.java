package com.example.demo.repository;

import com.example.demo.mapper.PatientFhirMapper;
import com.example.demo.exceptions.PatientNotFoundException;
import com.example.demo.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientFhirRepository {

    @Autowired
    private IGenericClient fhirClient;

    @Autowired
    private PatientFhirMapper patientFhirMapper;

    public Patient get(String id) throws PatientNotFoundException {
        try {
            org.hl7.fhir.r4.model.Patient fhirPatient =
                    fhirClient.read().resource(org.hl7.fhir.r4.model.Patient.class).withId(id).execute();
            return patientFhirMapper.transformFromFhir(fhirPatient);
        } catch (ResourceNotFoundException e) {
            throw new PatientNotFoundException(id);
        }
    }

    public boolean existsById(String id) {
        boolean found = true;
        try {
            fhirClient.read().resource(org.hl7.fhir.r4.model.Patient.class).withId(id).execute();
        } catch (ResourceNotFoundException ex) {
            found = false;
        }
        return found;
    }

}
