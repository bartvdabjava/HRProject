package be.vdab.training.domain.classes.concreteclasses;

import be.vdab.training.domain.classes.abstractclasses.BaseDomain;

public class Project extends BaseDomain {
    protected String projectName;
    protected String projectDescription;

    public Project(String projectName, String projectDescription) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public String getProjectName() {

        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
}
