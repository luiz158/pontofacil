/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.serpro.pontofacil.rn;

import br.org.serpro.pontofacil.entity.Relogio;
import br.org.serpro.pontofacil.exception.LoginFalhou;
import junit.framework.TestCase;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

/**
 *
 * @author 72767863587
 */
public class SiscopRNTest extends TestCase {

    public SiscopRNTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testDoLoginSucess() throws Exception {
        fail();
        
        System.out.println("doLoginSucess");
        SiscopRN instance = new SiscopRN();
        StatusLine status = instance.doLogin("xxx", "xxx");
        assertEquals(status.getStatusCode(), 302);
    }

    public void testDoLoginFail() throws Exception {
        fail();
        
        System.out.println("doLoginFail");
        SiscopRN instance = new SiscopRN();
        StatusLine status = null;
        try {
            status = instance.doLogin("00000000000", "00000");
        } catch (LoginFalhou loginFalhou) {
            
            if (loginFalhou.statusLine.getStatusCode() != 200) {
                fail();
            }
        }
    }

    public void testObterPonto() throws Exception {
        System.out.println("obterPonto");
        HttpResponse response = null;
        SiscopRN instance = new SiscopRN();
        Relogio expResult = null;
        
        instance.doLogin("xxx", "xxx");
        Relogio result = instance.obterPonto();
        assertNotNull(result);
    }
}
