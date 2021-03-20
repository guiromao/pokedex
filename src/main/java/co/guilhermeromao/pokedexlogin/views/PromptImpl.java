package co.guilhermeromao.pokedexlogin.views;

import co.guilhermeromao.pokedexlogin.controllers.LoginController;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class PromptImpl {

    private Prompt prompt;
    private LoginController loginController;

    public PromptImpl(){
        prompt = new Prompt(System.in, System.out);
    }

    public String getString(String string){
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(string);

        return prompt.getUserInput(scanner);
    }

}
