package be.vdab.training.domain.classes.concreteclasses;

import be.vdab.training.domain.classes.abstractclasses.Renumeration;

public class MealVoucher extends Renumeration {
    public MealVoucher(Integer cost) {
        this.setCost(cost);
    }
}
