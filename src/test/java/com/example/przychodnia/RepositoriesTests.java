package com.example.przychodnia;

import com.example.przychodnia.entity.*;
import com.example.przychodnia.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RepositoriesTests {

    @Autowired
    private DatesRepository datesRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private VisitRepository visitRepository;


    @Test
    public void datesRepositoryTest() {
        List<Dates> dates = datesRepository.findAll();
        Assertions.assertTrue(dates.size() > 0);
    }

    @Test
    public void patientRepositoryTest() {
        List<Patient> patients = patientRepository.findAll();
        Assertions.assertTrue(patients.size() > 0);
    }

    @Test
    public void roleRepositoryTest() {
        List<Role> roles = roleRepository.findAll();
        Assertions.assertTrue(roles.size() > 0);
    }

    @Test
    public void usersRepositoryTest() {
        List<Users> users = usersRepository.findAll();
        Assertions.assertTrue(users.size() > 0);
    }

    @Test
    public void visitRepositoryTest() {
        List<Visit> visits = visitRepository.findAll();
        Assertions.assertTrue(visits.size() > 0);
    }

}
