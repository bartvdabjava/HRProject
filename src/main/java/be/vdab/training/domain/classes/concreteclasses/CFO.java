package be.vdab.training.domain.classes.concreteclasses;

import be.vdab.training.domain.classes.abstractclasses.Renumeration;
import be.vdab.training.enums.DriversLicense;
import be.vdab.training.enums.Gender;
import be.vdab.training.enums.Transport;

import java.time.LocalDate;

public class CFO extends CXO {

    public CFO (String firstName, String middleName, String familyName, Gender gender, Transport[] transport,
                Object[] nationality, LocalDate birthDate, LocalDate dateOfHire, Address address,
                String socialSecurityNumber, DriversLicense driversLicense, Department workerDepartment,
                Project[] projects, Renumeration[] renumerations) {
        super(firstName, middleName, familyName, gender, transport, nationality, birthDate, dateOfHire, address, socialSecurityNumber,
                driversLicense, workerDepartment, projects, validateRenumerations(renumerations));
    }
}

