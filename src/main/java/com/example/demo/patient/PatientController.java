package com.example.demo.patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@Tag(name = "Patients", description = "The Patients API")
@RestController
@RequestMapping("/api/model/Patient")
public class PatientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    PatientService patientService;

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable String id) {

        try {
            Patient patient = patientService.get(id);

            if (patient != null) {
                return ResponseEntity.ok(patient);
            }

        } catch (Exception ex) {
            LOGGER.error("PatientController: get ", ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);


    }


}
