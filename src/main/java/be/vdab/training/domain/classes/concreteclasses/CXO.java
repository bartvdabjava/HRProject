package be.vdab.training.domain.classes.concreteclasses;

import be.vdab.training.domain.classes.abstractclasses.Renumeration;
import be.vdab.training.domain.classes.abstractclasses.Worker;
import be.vdab.training.enums.DriversLicense;
import be.vdab.training.enums.Gender;
import be.vdab.training.enums.Transport;

import java.time.LocalDate;

public class CXO extends Worker {


    public CXO (String firstName, String middleName, String familyName, Gender gender, Transport[] transport,
            Object[] nationality, LocalDate birthDate, LocalDate dateOfHire, Address address,
            String socialSecurityNumber, DriversLicense driversLicense, Department workerDepartment,
            Project[] projects, Renumeration[] renumerations) {
        super(firstName,middleName,familyName,gender,transport,nationality,birthDate,dateOfHire,address,socialSecurityNumber,
                driversLicense, workerDepartment, projects, validateRenumerations(renumerations));

    }

    protected static Renumeration[] validateRenumerations(Renumeration[] renumerations) {
        renumerations=checkRenumerations(renumerations);
        return renumerations;
    }

    @Override
    public void setRenumerations(Renumeration[] renumerationsInput) {
        renumerations=checkRenumerations(renumerationsInput);
        this.renumerations=renumerations;
    }

    private static Renumeration[] checkRenumerations(Renumeration[] renumerations) {
        int countHospital=0;
        int countGSM=0;
        int countSal=0;
        int countMealVoucher=0;
        int totalCount=0;
        for (Renumeration renum: renumerations){
            try {
                if (renum instanceof HospitalisationInsurance) {
                    countHospital += 1;
                } else if (renum instanceof GSM) {
                    countGSM += 1;
                } else if (renum instanceof Salary) {
                    countSal += 1;
                } else if (renum instanceof MealVoucher) {
                    countMealVoucher += 1;
                }
                totalCount+=1;
            } catch (NullPointerException e){
                continue;
            }
        }
        if (totalCount<4 || countHospital>1 || countSal>1 || countMealVoucher>1 || countGSM >2){
            throw new RuntimeException("These renumerations are not appropriate for an CXO. A cxo should" +
                    "minimally have 4 renumerations  (1*salary/1*mealvoucher/1*hospitalisation insurance/2*GSM");
        }
        return renumerations;
    }




    public double calculateTotalIncentiveCost(){
        return 0.0;
    }




}
