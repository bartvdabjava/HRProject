package be.vdab.training.domain.classes.concreteclasses;


import be.vdab.training.domain.classes.abstractclasses.Renumeration;
import be.vdab.training.domain.classes.abstractclasses.Worker;
import be.vdab.training.enums.DriversLicense;
import be.vdab.training.enums.Gender;
import be.vdab.training.enums.Transport;

import java.time.LocalDate;

public class Employee extends Worker implements Comparable<Employee> {
    private Manager manager;

    public Employee(){};

    public Employee(String firstName, String middleName, String familyName, Gender gender, Transport[] transport,
                    Object[] nationality, LocalDate birthDate, LocalDate dateOfHire, Address address,
                    String socialSecurityNumber, DriversLicense driversLicense, Department workerDepartment,
                    Project[] projects, Renumeration[] renumerations, Manager manager) {
        super(firstName,middleName,familyName,gender,transport,nationality,birthDate,dateOfHire,address,socialSecurityNumber,
                driversLicense, workerDepartment, projects, validateRenumerations(renumerations));
        this.manager = manager;
    }

    private static Renumeration[] validateRenumerations(Renumeration[] renumerations) {
        renumerations=checkRenumerations(renumerations);
        return renumerations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        return manager != null ? manager.equals(employee.manager) : employee.manager == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        return result;
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
        if (totalCount<2 || countHospital>1 || countSal>1 || countMealVoucher>1 || countGSM >2){
            throw new RuntimeException("These renumerations are not appropriate for an employee. An employee should" +
                    "minimally have 2 renumerations  (1*salary/1*mealvoucher/1*hospitalisation insurance/2*GSM");
        }
        return renumerations;
    }




    public double calculateTotalIncentiveCost(){
        double totalcost=0;
        for(Renumeration renum: renumerations){
            totalcost+=renum.getCost();
        }
        return totalcost;
    }

    public int compareTo(Employee other){
        Long returnAge= this.getAge(this.getBirthDate())<other.getAge(other.getBirthDate())?other.getAge(other.getBirthDate())
                :this.getAge(this.getBirthDate());
        return returnAge.intValue();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
