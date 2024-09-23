package com.example.sessiontest.sse.model.bootstrap;

import com.example.sessiontest.sse.model.Emp;
import com.example.sessiontest.sse.service.EmpService;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@Component
public class DefaultEmpLoader implements CommandLineRunner {
    private static final String[] GENDER = {"Male", "Female", "Transgender", "Not to specify"};
    private static final Random RANDOM = new Random();

    private final EmpService service;
    private final Faker faker;

    @Override
    public void run(String... args) throws Exception {
        loadEmployees();
    }

    // Saving the default employees data in the database.
    private void loadEmployees() {
        int count = 0;
        if (service.getTotalEmployees() == 0) {
            for (int x = 0; x < 100; x++) {
                count = count + 1;
                service.save(createNewEmployee());
            }
            log.info("Total {} employees are saved in the database.", count);
        } else {
            log.info("Default employees are already present in the database.");
        }
    }

    private Emp createNewEmployee() {
        final String firstName = faker.name().firstName();
        final String lastName = faker.name().lastName();
        final String gender = GENDER[RANDOM.nextInt(GENDER.length)];
        final String emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@somecompany.com";

        return Emp.builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .email(emailAddress)
                .phoneNumber(faker.phoneNumber().cellPhone())
                .homeAddress(faker.address().fullAddress())
                .build();
    }
}
