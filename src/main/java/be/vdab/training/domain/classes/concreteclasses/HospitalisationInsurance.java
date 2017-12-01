package be.vdab.training.domain.classes.concreteclasses;

import be.vdab.training.domain.classes.abstractclasses.Renumeration;

public class HospitalisationInsurance extends Renumeration {
    public HospitalisationInsurance(Integer cost) {
        this.setCost(cost);
    }
}
