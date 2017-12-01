package be.vdab.training.domain.classes.concreteclasses;

import be.vdab.training.domain.classes.abstractclasses.Renumeration;

public class GSM extends Renumeration{
    protected String typeofGSM;
    protected String Msisdn;


    public GSM(){};

    public GSM(String typeofGSM, String msisdn, Integer cost) {
        this.setCost(cost);
        this.typeofGSM = typeofGSM;
        this.Msisdn = validate(msisdn);
    }

    public String validate(String msisdn) {

        if (msisdn.length()!=10 || msisdn.charAt(0)!='0'){
            throw new RuntimeException("please enter a valid msisdn");
        } else {
            return msisdn;
        }
    }

    public String getTypeofGSM() {
        return typeofGSM;
    }

    public void setTypeofGSM(String typeofGSM) {
        this.typeofGSM = typeofGSM;
    }

    public String getMsisdn() {
        return Msisdn;
    }

    public void setMsisdn(String msisdn) {
        Msisdn = msisdn;
    }
}
