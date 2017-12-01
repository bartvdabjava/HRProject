package be.vdab.training.domain.concreteclasses;

import be.vdab.training.domain.classes.concreteclasses.GSM;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class GSMTest {

    @Rule
    public final ExpectedException exception=ExpectedException.none();

    @Test
    public void GSMTestMsisdn(){
        GSM gsm=new GSM();
        gsm.setMsisdn("0123456789");
        assertEquals("Testing msisdn","0123456789", gsm.validate(gsm.getMsisdn()));
    }

    @Test
    public void GSMTestFaultyTooLongMsisdn(){
        GSM gsm=new GSM();
        gsm.setMsisdn("01234567899");
        exception.expect(RuntimeException.class);
        gsm.validate(gsm.getMsisdn());
    }

    @Test
    public void GSMTestFaultyTooShortgMsisdn(){
        GSM gsm=new GSM();
        gsm.setMsisdn("012345678");
        exception.expect(RuntimeException.class);
        gsm.validate(gsm.getMsisdn());
    }

    @Test
    public void GSMTestFaultyNotStartingWithZeroMsisdn(){
        GSM gsm=new GSM();
        gsm.setMsisdn("1234567899");
        exception.expect(RuntimeException.class);
        gsm.validate(gsm.getMsisdn());
    }



}
