package be.vdab.training.domain.classes.genericclasses;

import be.vdab.training.domain.classes.abstractclasses.Worker;


public class PairWorker <E1 extends Worker, E2 extends Worker>  {
    private E1 firstWorker;
    private E2 secondWorker;

    public PairWorker(E1 firstWorker, E2 secondWorker){
        this.firstWorker=firstWorker;
        this.secondWorker=secondWorker;
    }

    public E1 getFirstWorker() {
        return firstWorker;
    }

    public void setFirstWorker(E1 firstWorker) {
        this.firstWorker = firstWorker;
    }

    public E2 getSecondWorker() {
        return secondWorker;
    }

    public void setSecondWorker(E2 secondWorker) {
        this.secondWorker = secondWorker;
    }

    public String pairProgramming(){
        return String.format("%s works together with %s",firstWorker.getFirstName(), secondWorker.getFirstName());
    }
}
