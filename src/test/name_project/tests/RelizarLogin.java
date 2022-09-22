package tests;

import baseTest.BaseTest;
import interactions.LoginPageInteractions;
import org.testng.annotations.Test;

public class RelizarLogin extends BaseTest {

    @Test
    public void realizarLoginComSucesso(){
        LoginPageInteractions loginPageInteractions = new LoginPageInteractions();

        loginPageInteractions.
                insereEmail().
                insereSenha().
                botaoEntrarClicado().
                verificaUsuarioAutenticado();
    }
}
