package com.example.demo.patient;


import com.example.demo.repository.PatientFhirRepository;
import com.example.demo.exceptions.PatientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientFhirRepository patientFhirRepository;


    public Patient get(String id) throws PatientNotFoundException {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("The patient id is null or empty");
        }

        Patient patient = patientFhirRepository.get(id);
        return patient;
    }


}

