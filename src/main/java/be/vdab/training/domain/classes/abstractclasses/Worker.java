package be.vdab.training.domain.classes.abstractclasses;




import be.vdab.training.domain.classes.concreteclasses.Department;
import be.vdab.training.domain.classes.concreteclasses.Project;
import be.vdab.training.enums.DriversLicense;
import be.vdab.training.enums.Gender;
import be.vdab.training.enums.Transport;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;


public abstract class Worker extends BaseDomain {

    private static final Logger LOGGER= LogManager.getLogger(Worker.class);

    protected String firstName;
    protected String middleName;
    protected String familyName;
    protected Gender gender;
    protected Transport[] transport;
    protected Object[] nationality;

    protected LocalDate birthDate;


    public class Address {
        protected String street;
        protected int houseNumber;
        protected String city;

        public Address (String street, int houseNumber, String city){
            this.street=street;
            this.houseNumber=houseNumber;
            this.city=city;
        }
    }

    protected LocalDate dateOfHire;
    protected Address address;
    protected String socialSecurityNumber;
    /* TODO
    check social security number;
     */
    protected DriversLicense driversLicense;
    protected Department workerDepartment;
    protected Project[] projects;
    protected Renumeration[] renumerations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        if (!super.equals(o)) return false;

        Worker worker = (Worker) o;

        if (getFirstName() != null ? !getFirstName().equals(worker.getFirstName()) : worker.getFirstName() != null)
            return false;
        if (getFamilyName() != null ? !getFamilyName().equals(worker.getFamilyName()) : worker.getFamilyName() != null)
            return false;
        if (getMiddleName() != null ? !getMiddleName().equals(worker.getMiddleName()) : worker.getMiddleName() != null)
            return false;

        if (getGender() != worker.getGender()) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getTransport(), worker.getTransport())) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getNationality(), worker.getNationality())) return false;
        if (getBirthDate() != null ? !getBirthDate().equals(worker.getBirthDate()) : worker.getBirthDate() != null)
            return false;
        if (getDateOfHire() != null ? !getDateOfHire().equals(worker.getDateOfHire()) : worker.getDateOfHire() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(worker.getAddress()) : worker.getAddress() != null)
            return false;
        if (getSocialSecurityNumber() != null ? !getSocialSecurityNumber().equals(worker.getSocialSecurityNumber()) : worker.getSocialSecurityNumber() != null)
            return false;
        if (getDriversLicense() != worker.getDriversLicense()) return false;
        if (getWorkerDepartment() != null ? !getWorkerDepartment().equals(worker.getWorkerDepartment()) : worker.getWorkerDepartment() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getProjects(), worker.getProjects())) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getRenumerations(), worker.getRenumerations());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getMiddleName() != null ? getMiddleName().hashCode() : 0);
        result = 31 * result + (getFamilyName() != null ? getFamilyName().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getTransport());
        result = 31 * result + Arrays.hashCode(getNationality());
        result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
        result = 31 * result + (getDateOfHire() != null ? getDateOfHire().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getSocialSecurityNumber() != null ? getSocialSecurityNumber().hashCode() : 0);
        result = 31 * result + (getDriversLicense() != null ? getDriversLicense().hashCode() : 0);
        result = 31 * result + (getWorkerDepartment() != null ? getWorkerDepartment().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getProjects());
        result = 31 * result + Arrays.hashCode(getRenumerations());
        return result;
    }

    public Worker(){};

    public Worker(String firstName, String middleName, String familyName, Gender gender, Transport[] transport,
                  Object[] nationality, LocalDate birthDate, LocalDate dateOfHire, Address address,
                  String socialSecurityNumber, DriversLicense driversLicense, Department workerDepartment,
                  Project[] projects, Renumeration[] renumerations){
        this.firstName=firstName;
        this.middleName=middleName;
        this.familyName=familyName;
        this.gender=gender;
        this.transport=validatetransport(transport);
        this.nationality=validatenationality(nationality);
        this.birthDate=validatebirthdate(birthDate);
        this.dateOfHire=validatedateOfHire(dateOfHire);
        this.address=address;
        this.socialSecurityNumber=validateSocialSecurityNumber(socialSecurityNumber);
        this.driversLicense=driversLicense;
        this.workerDepartment=workerDepartment;
        this.projects=validateprojects(projects);
        this.renumerations=validaterenumerations(renumerations);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Transport[] getTransport() {
        return transport;
    }

    public void setTransport(Transport[] transport) {
        this.transport = validatetransport(transport);
    }

    public Object[] getNationality() {
        return nationality;
    }

    public void setNationality(Object[] nationality) {
        this.nationality = validatenationality(nationality);
    }

    public LocalDate getBirthDate() {
        try{return birthDate;}
        catch(NullPointerException npe){
            System.err.print("No birthdate specified");
            return null;
        }
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = validatebirthdate(birthDate);
    }

    public LocalDate getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(LocalDate dateOfHire) {
        this.dateOfHire = validatedateOfHire(dateOfHire);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public DriversLicense getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(DriversLicense driversLicense) {
        this.driversLicense = driversLicense;
    }

    public Department getWorkerDepartment() {
        return workerDepartment;
    }

    public void setWorkerDepartment(Department workerDepartment) {
        this.workerDepartment = workerDepartment;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }

    private Renumeration[] validaterenumerations(Renumeration[] renumerations) {
        if (renumerations.length>4){
            throw new RuntimeException("A worker cannot have more than 4 renumerations");
        } else {
            return renumerations;
        }

    }

    private Project[] validateprojects(Project[] projects) {
        if (projects.length>5){
            throw new RuntimeException("A worker cannot have more than five projects");
        } else {
            return projects;
        }

    }

    public String validateSocialSecurityNumber(String socialSecurityNumber) {



        socialSecurityNumber=socialSecurityNumber.replace(".","").replace("-","");
        RuntimeException socialError=new RuntimeException("This social security number is not correct: "+socialSecurityNumber);


        if (this.getBirthDate()==null || this.getGender()==null){
            String message=this.getBirthDate()==null?"No birthdate provided":"No gender provided";
            LOGGER.info(message);
            throw socialError;
        }
        if (socialSecurityNumber.length()!=11){
            LOGGER.info("Social security number is not the right length");
            throw socialError;
        }



        String birthYear=Integer.toString(birthDate.getYear()).substring(2);
        String birtYearSocial=socialSecurityNumber.substring(0,2);
        String birthMonth=Integer.toString(birthDate.getMonthValue());
        if (birthMonth.length()<2){
            birthMonth="0"+birthMonth;
        }
        String birthMonthSocial=socialSecurityNumber.substring(2,4);
        String birthDay=Integer.toString(birthDate.getDayOfMonth());
        String birthDaySocial=socialSecurityNumber.substring(4,6);

        if (!birthYear.equals(birtYearSocial) || !birthMonth.equals(birthMonthSocial) || !birthDay.equals(birthDaySocial)){
            LOGGER.info("Social security number does not have the right birthday");
            throw socialError;
        }

        int secondgroup= Integer.parseInt(socialSecurityNumber.substring(6,9));
        if (secondgroup>=999){
            LOGGER.info("secondgroup should be smaller than 1000");
            throw socialError;
        }
        if (gender.name()=="MALE" && secondgroup%2==0){
            LOGGER.info("Second group should be odd for a man");
            throw socialError;
        }
        if (gender.name()=="FEMALE" && secondgroup%2!=0){
            LOGGER.info("Second group should be even for a woman");
            throw socialError;
        }

        String secondGroupString=Integer.toString(secondgroup);

        BigInteger nineSeven=new BigInteger("97");

        String thirdGroup=socialSecurityNumber.substring(9);
        if (birthDate.getYear()>=2000){
           String newSocialSecurityNumber="2"+socialSecurityNumber.substring(0,9);
           BigInteger bigSocialSecurityNumber=new BigInteger(newSocialSecurityNumber);


           if (Integer.parseInt(thirdGroup)!=(97 - (bigSocialSecurityNumber.divideAndRemainder(nineSeven)[1].intValue()))){
               LOGGER.info("Something is wrong with the third group of numbers in the social security number");
               throw socialError;
           }
        }

        BigInteger bigSocialSecurityNumber=new BigInteger(socialSecurityNumber.substring(0,9));



        if (97-(bigSocialSecurityNumber.divideAndRemainder(nineSeven)[1].intValue())!=Integer.parseInt(thirdGroup)){
            LOGGER.info("Something is wrong with the third group of numbers in the social security number");
            throw socialError;
        }

        socialSecurityNumber=birtYearSocial+"."+birthMonthSocial+"."+birthDaySocial+"-"+secondGroupString+"."+thirdGroup;

        return socialSecurityNumber;
    }

    public LocalDate validatedateOfHire(LocalDate dateOfHire) {
        if (this.getBirthDate()==null){
            throw new RuntimeException("No birthdate specified");
        }
        LocalDate currentDate=LocalDate.now();
        Long monthsBetween= ChronoUnit.MONTHS.between(currentDate,dateOfHire);
        Long yearsBetween=ChronoUnit.YEARS.between(birthDate,dateOfHire);
        System.out.println(currentDate+" "+dateOfHire+" "+monthsBetween);
        if (yearsBetween<18 || monthsBetween>2){
            throw new RuntimeException("A worker cannot be hired more than two months from now");
        } else {
            return dateOfHire;
        }
    }

    public Transport[] validatetransport(Transport[] transport) {
        if (transport.length>3){
            throw new RuntimeException("A worker cannot have more than three ways of transport");
        } else {
            return transport;
        }
    }


    public LocalDate validatebirthdate(LocalDate birthDate) {
        LocalDate currentDate=LocalDate.now();
        Long yearsbetween=ChronoUnit.YEARS.between(birthDate,currentDate);

        if (yearsbetween<18){
            throw new RuntimeException("A worker cannot be younger than 18.");
        } else {
            return birthDate;
        }
    }

    public Object[] validatenationality(Object[] nationality) {
        if (nationality.length>3){
            throw new RuntimeException("A worker cannot have more than three nationalities");
        } else {
            return nationality;
        }
    }


    public abstract void setRenumerations(Renumeration[] renumerationsInput);

    public abstract double calculateTotalIncentiveCost();

    public Project[] getProjects() {
        if (projects==null){
            projects=new Project[5];
            return projects;
        } else {
            return projects;
        }
    }

    public Renumeration[] getRenumerations() {
        if (renumerations==null){
            renumerations=new Renumeration[4];
            return renumerations;
        } else {
            return renumerations;
        }
    }



    public long getSeniority (){
        LocalDate nowDate=LocalDate.now();
        return ChronoUnit.DAYS.between(nowDate,this.dateOfHire);
    }




    public String getFullName(){
        return String.format("%s %s %s", this.firstName, this.middleName, this.familyName);
    }

    public String getFullName(String... stringArray){
        String[] fullName=new String[3];
        for (int i=0; i<stringArray.length; i++){
            try{
                fullName[i]=stringArray[i];
            } catch (Exception e){
                switch (i){
                    case 0:
                        fullName[i]=this.firstName;
                    case 1:
                        fullName[i]=this.middleName;
                    case 2:
                        fullName[i]=this.familyName;
                }
            }
        }
        return String.format("%s %s %s",fullName[0], fullName[1],fullName[2]);
    }

    public Long getAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Long yearsbetween = ChronoUnit.YEARS.between(birthDate, currentDate);
        return yearsbetween;
    }


}
