package be.vdab.training.domain.classes.genericclasses;

import be.vdab.training.domain.classes.concreteclasses.Employee;

public class ComparableDuo<E extends Employee> {

    private E firstWorker;
    private E secondWorker;

    public ComparableDuo(E firstWorker, E secondWorker){
        this.firstWorker=firstWorker;
        this.secondWorker=secondWorker;
    }

    public E getHighest(){
        return this.firstWorker.compareTo(this.secondWorker)<0?this.secondWorker:this.firstWorker;
    }

}