package be.vdab.training.domain.concreteclasses;

import be.vdab.training.domain.classes.concreteclasses.Employee;
import be.vdab.training.enums.Gender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    @Rule
    public final ExpectedException exception=ExpectedException.none();

    private static final Logger LOGGER= LogManager.getLogger(EmployeeTest.class);

    @Test
    public void testEmployeeFirstName(){
        LOGGER.info("This is a dummy log statement");
        Employee employee=new Employee();
        employee.setFirstName("wim");

        assertEquals("getter and setter van first-name","wim",employee.getFirstName());
    }

    @Test
    public void testEmployeeMaleValidSocialSecurityNumber(){
        Employee employee=new Employee();
        employee.setSocialSecurityNumber("89.01.10-139.79");
        LocalDate birthday=LocalDate.of(1989,01,10);
        employee.setBirthDate(birthday);
        Gender myGender=Gender.MALE;
        employee.setGender(myGender);

        assertEquals("Test for valid social security number","89.01.10-139.79",employee.validateSocialSecurityNumber(
                employee.getSocialSecurityNumber()));
    }


    @Test
    public void testEmployeeMaleFaultyTooManyNumbersSocialSecurityNumber(){
        Employee employee=new Employee();
        employee.setSocialSecurityNumber("89.01.10-139.798");
        LocalDate birthday=LocalDate.of(1989,01,10);
        employee.setBirthDate(birthday);
        Gender myGender=Gender.MALE;
        employee.setGender(myGender);

        exception.expect(RuntimeException.class);
        employee.validateSocialSecurityNumber(employee.getSocialSecurityNumber());
    }

    @Test
    public void testEmployeeMaleFaultyWrongSecondGroupSocialSecurityNumber(){
        Employee employee=new Employee();
        LocalDate birthday=LocalDate.of(1989,01,10);
        employee.setBirthDate(birthday);
        Gender myGender=Gender.MALE;
        employee.setGender(myGender);

        employee.setSocialSecurityNumber("89.01.10-138.79");


        exception.expect(RuntimeException.class);
        employee.validateSocialSecurityNumber(employee.getSocialSecurityNumber());
    }

    @Test
    public void testEmployeeMaleFaultyWrongThirdGroupSocialSecurityNumber(){
        Employee employee=new Employee();
        employee.setSocialSecurityNumber("89.01.10-139.78");
        LocalDate birthday=LocalDate.of(1989,01,10);
        employee.setBirthDate(birthday);
        Gender myGender=Gender.MALE;
        employee.setGender(myGender);

        exception.expect(RuntimeException.class);
        employee.validateSocialSecurityNumber(employee.getSocialSecurityNumber());
    }

    @Test
    public void testEmployeeFemaleValidSocialSecurityNumber(){
        Employee employee=new Employee();
        employee.setSocialSecurityNumber("89.01.10-140.78");
        LocalDate birthday=LocalDate.of(1989,01,10);
        employee.setBirthDate(birthday);
        Gender myGender=Gender.FEMALE;
        employee.setGender(myGender);

        assertEquals("Test for valid social security number","89.01.10-140.78",employee.validateSocialSecurityNumber(
                employee.getSocialSecurityNumber()));
    }

    @Test
    public void testEmployeeFemaleWrongSecondGroupSocialSecurityNumber(){
        Employee employee=new Employee();
        employee.setSocialSecurityNumber("89.01.10-139.78");
        LocalDate birthday=LocalDate.of(1989,01,10);
        employee.setBirthDate(birthday);
        Gender myGender=Gender.FEMALE;
        employee.setGender(myGender);

        exception.expect(RuntimeException.class);
        employee.validateSocialSecurityNumber(employee.getSocialSecurityNumber());
    }

    @Test
    public void testEmployeeFemaleWrongThirdGroupSocialSecurityNumber(){
        Employee employee=new Employee();
        employee.setSocialSecurityNumber("89.01.10-140.76");
        LocalDate birthday=LocalDate.of(1989,01,10);
        employee.setBirthDate(birthday);
        Gender myGender=Gender.FEMALE;
        employee.setGender(myGender);

        exception.expect(RuntimeException.class);
        employee.validateSocialSecurityNumber(employee.getSocialSecurityNumber());
    }


    @Test
    public void testEmployeeMaleFaultyNoBirthDateSocialSecurityNumber(){
        Employee employee=new Employee();

        Gender myGender=Gender.MALE;
        employee.setGender(myGender);

        employee.setSocialSecurityNumber("89.01.10-138.79");


        exception.expect(RuntimeException.class);
        employee.validateSocialSecurityNumber(employee.getSocialSecurityNumber());
    }

    @Test
    public void testEmployeeMaleFaultyNoGenderSocialSecurityNumber(){
        Employee employee=new Employee();

        LocalDate birthday=LocalDate.of(1989,01,10);
        employee.setBirthDate(birthday);
        employee.setSocialSecurityNumber("89.01.10-138.79");

        exception.expect(RuntimeException.class);
        employee.validateSocialSecurityNumber(employee.getSocialSecurityNumber());
    }

    @Test
    public void testEmployeeBirthDate(){
        Employee employee=new Employee();
        LocalDate birthDate=LocalDate.of(1989,1,10);
        employee.setBirthDate(birthDate);

        assertEquals("Testing the birthday",birthDate, employee.validatebirthdate(employee.getBirthDate()));
    }

    @Test
    public void testEmployeeFaultyBirthDate(){
        Employee employee=new Employee();
        LocalDate birthDate=LocalDate.of(2009,1,10);
        exception.expect(RuntimeException.class);
        employee.setBirthDate(birthDate);
        employee.validatebirthdate(employee.getBirthDate());
    }

    @Test
    public void testEmployeeNoBirthDay(){
        Employee employee=new Employee();
        exception.expect(RuntimeException.class);
        employee.validatebirthdate(employee.getBirthDate());
    }


    @Test
    public void testEmployeeDateOfHire(){
        Employee employee=new Employee();
        LocalDate birthDate=LocalDate.of(1989,1,10);
        employee.setBirthDate(birthDate);
        LocalDate dateOfHire=LocalDate.of(2017,1,10);
        employee.setDateOfHire(dateOfHire);

        assertEquals("Testing the dateofhire",dateOfHire, employee.validatedateOfHire(employee.getDateOfHire()));
    }

    @Test
    public void testEmployeeLateDateOfHire(){
        Employee employee=new Employee();
        LocalDate birthDate=LocalDate.of(1989,1,10);
        employee.setBirthDate(birthDate);
        LocalDate dateOfHire=LocalDate.of(2018,3,10);
        exception.expect(RuntimeException.class);

        employee.setDateOfHire(dateOfHire);

    }

    @Test
    public void testEmployeeDateOfHireBefore18(){
        Employee employee=new Employee();
        LocalDate birthDate=LocalDate.of(1989,1,10);
        employee.setBirthDate(birthDate);
        LocalDate dateOfHire=LocalDate.of(1999,4,10);

        exception.expect(RuntimeException.class);

        employee.setDateOfHire(dateOfHire);
    }





}
