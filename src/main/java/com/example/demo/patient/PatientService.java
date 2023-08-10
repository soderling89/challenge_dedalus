package com.example.demo.patient;

import com.example.demo.exceptions.PatientNotFoundException;

public interface PatientService {
    public Patient get(String id) throws PatientNotFoundException;
}
