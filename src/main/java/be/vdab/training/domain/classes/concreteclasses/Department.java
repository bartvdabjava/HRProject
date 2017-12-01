package be.vdab.training.domain.classes.concreteclasses;

import be.vdab.training.domain.classes.abstractclasses.BaseDomain;

public class Department extends BaseDomain {
    protected String departmentName;
    protected String departmentDescription;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public Department(String departmentName, String departmentDescription) {

        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
    }
}
