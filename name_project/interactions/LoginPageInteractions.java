package interactions;

import com.relevantcodes.extentreports.LogStatus;
import enums.NomeProjetoEnum;
import extentReport.ExtentTestManager;
import org.testng.Assert;
import pages.LoginPage;
import seleniumTools.SeleniumTools;
import support.Assistant;

public class LoginPageInteractions extends LoginPage {

    SeleniumTools seleniumTools = new SeleniumTools();

    public LoginPageInteractions insereEmail(){
        seleniumTools.sendTextId(emailInput, Assistant.getConfigPropertiesValues(NomeProjetoEnum.NOME_PROJETO_ENUM, "email"));
        ExtentTestManager.getTest().log(LogStatus.PASS, "Email do usuário foi inserido");
        return this;
    }

    public LoginPageInteractions insereSenha(){
        seleniumTools.sendTextId(senhaInput, Assistant.getConfigPropertiesValues(NomeProjetoEnum.NOME_PROJETO_ENUM, "senha"));
        ExtentTestManager.getTest().log(LogStatus.PASS, "Senha do usuário foi inserido");
        return this;
    }

    public LoginPageInteractions botaoEntrarClicado(){
        seleniumTools.clickElementXpath(botaoEntrar);
        ExtentTestManager.getTest().log(LogStatus.PASS, "Botão entrar é clicado");
        return this;
    }

    public LoginPageInteractions verificaUsuarioAutenticado(){
    String texto = seleniumTools.getTextXpath(usuarioAutenticado);
        if(texto.contains("Leomar")){
            Assert.assertEquals("Bem vindo, Leomar Barbosa!",texto);
        }
        return this;
    }

    public LoginPageInteractions verificaMensagemAlertaEmail(){
        String texto = seleniumTools.getTextXpath(mensagemAlerta);
        if(texto.contains("Email")){
            Assert.assertEquals("Email é um campo obrigatório",texto);
        }
        return this;
    }

    public LoginPageInteractions verificaMensagemAlertaSenha(){
        String texto = seleniumTools.getTextXpath(mensagemAlerta);
        if(texto.contains("Senha")){
            Assert.assertEquals("Senha é um campo obrigatório",texto);
        }
        return this;
    }

}
