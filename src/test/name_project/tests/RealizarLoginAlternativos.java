package tests;

import baseTest.BaseTest;
import interactions.LoginPageInteractions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Parameters({"regressao"})
public class RealizarLoginAlternativos extends BaseTest {

    @Test
    public void realizarLoginSemInserirEmail(){
        LoginPageInteractions loginPageInteractions = new LoginPageInteractions();

        loginPageInteractions.
                insereSenha().
                botaoEntrarClicado().
                verificaMensagemAlertaEmail();
    }

    @Test
    public void realizarLoginSemInserirSenha(){
        LoginPageInteractions loginPageInteractions = new LoginPageInteractions();

        loginPageInteractions.
                insereEmail().
                botaoEntrarClicado().
                verificaMensagemAlertaSenha();
    }

}
