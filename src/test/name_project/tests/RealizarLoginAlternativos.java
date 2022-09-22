package tests;

import baseTest.BaseTest;
import interactions.LoginPageInteractions;
import org.testng.annotations.Test;

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
