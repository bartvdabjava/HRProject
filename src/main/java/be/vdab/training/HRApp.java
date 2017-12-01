package be.vdab.training;





import be.vdab.training.domain.classes.abstractclasses.Worker;
import be.vdab.training.domain.classes.concreteclasses.Employee;
import be.vdab.training.domain.classes.concreteclasses.Manager;
import be.vdab.training.domain.classes.genericclasses.ComparableDuo;
import be.vdab.training.domain.classes.genericclasses.PairWorker;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDate;
import java.util.*;

public class HRApp {

    private static final Logger LOGGER= LogManager.getLogger(HRApp.class);


    public static void main(String[] args) {


        Collection<List<? extends Worker>> listOfEmployeesAndManagers=new ArrayList<>();

        ArrayList<Employee> employeeArrayList=new ArrayList<>();
        listOfEmployeesAndManagers.add(employeeArrayList);
        ArrayList<Manager> managerArrayList=new ArrayList<>();
        listOfEmployeesAndManagers.add(managerArrayList);

        Employee employee = new Employee();
        LocalDate employeebirthday=LocalDate.of(1989, 1, 10);
        employee.setBirthDate(employeebirthday);
        employee.setFirstName("Bart");
        employee.setMiddleName("A.R");
        employee.setFamilyName("Bruneel");
        Employee employee1=new Employee();
        employee1.setFirstName("Bart");
        employee1.setFamilyName("Bruneel");
        LocalDate employee1birthday=LocalDate.of(1992,7,25);
        employee1.setBirthDate(employee1birthday);

        Manager manager = new Manager();
        LocalDate managerbirthday=LocalDate.of(1989, 1, 10);
        employee.setBirthDate(managerbirthday);
        manager.setFirstName("Bart");
        manager.setMiddleName("A.R");
        manager.setFamilyName("Bruneel");
        Manager manager1=new Manager();
        manager1.setFirstName("Clara");
        manager1.setFamilyName("Casert");
        LocalDate manager1birthday=LocalDate.of(1992,7,25);
        employee1.setBirthDate(manager1birthday);

        employeeArrayList.add(employee);
        employeeArrayList.add(employee1);

        managerArrayList.add(manager);
        managerArrayList.add(manager1);

        for (List list: listOfEmployeesAndManagers){
            if(list!=null && list.get(0) instanceof Employee){
                for (Employee employeeiter: (List<Employee>) list){
                    System.out.println("Employee "+ employeeiter);
                }
            } else if(list!=null && list.get(0) instanceof Manager){
                for (Manager manageriter: (List<Manager>) list){
                    System.out.println("Manager "+manageriter);
                }
            }
        }



}

}

