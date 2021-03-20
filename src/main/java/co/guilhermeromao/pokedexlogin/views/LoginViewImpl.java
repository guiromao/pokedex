package co.guilhermeromao.pokedexlogin.views;

import co.guilhermeromao.pokedexlogin.controllers.LoginController;
import co.guilhermeromao.pokedexlogin.model.Trainer;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import java.util.Optional;

public class LoginViewImpl implements LoginView {

    private static final String OPENING_LETTERING = "\n" +
            " .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \n" +
            "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
            "| |   ______     | || |     ____     | || |  ___  ____   | || |  _________   | || |  ________    | || |  _________   | || |  ____  ____  | |\n" +
            "| |  |_   __ \\   | || |   .'    `.   | || | |_  ||_  _|  | || | |_   ___  |  | || | |_   ___ `.  | || | |_   ___  |  | || | |_  _||_  _| | |\n" +
            "| |    | |__) |  | || |  /  .--.  \\  | || |   | |_/ /    | || |   | |_  \\_|  | || |   | |   `. \\ | || |   | |_  \\_|  | || |   \\ \\  / /   | |\n" +
            "| |    |  ___/   | || |  | |    | |  | || |   |  __'.    | || |   |  _|  _   | || |   | |    | | | || |   |  _|  _   | || |    > `' <    | |\n" +
            "| |   _| |_      | || |  \\  `--'  /  | || |  _| |  \\ \\_  | || |  _| |___/ |  | || |  _| |___.' / | || |  _| |___/ |  | || |  _/ /'`\\ \\_  | |\n" +
            "| |  |_____|     | || |   `.____.'   | || | |____||____| | || | |_________|  | || | |________.'  | || | |_________|  | || | |____||____| | |\n" +
            "| |              | || |              | || |              | || |              | || |              | || |              | || |              | |\n" +
            "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
            " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \n";

    private static final String POKE_LETTERING = "\n" +
            "______     _            _           \n" +
            "| ___ \\   | |          | |          \n" +
            "| |_/ /__ | | _____  __| | _____  __\n" +
            "|  __/ _ \\| |/ / _ \\/ _` |/ _ \\ \\/ /\n" +
            "| | | (_) |   <  __/ (_| |  __/>  < \n" +
            "\\_|  \\___/|_|\\_\\___|\\__,_|\\___/_/\\_\\\n" +
            "                                    \n";

    private LoginController controller;
    private PromptImpl prompt;

    public LoginViewImpl(){
        prompt = new PromptImpl();
    }

    public void show(){
        String username;
        String password;

        System.out.println(OPENING_LETTERING);

        username = prompt.getString("Insert username: ");
        password = prompt.getString("Insert password: ");

        Optional<Trainer> trainer = controller.login(username, password);

        if(trainer != null){
            Trainer loggedTrainer = trainer.get();
            System.out.println(POKE_LETTERING);
            System.out.println("Welcome to your Pokedex, " + loggedTrainer.getTrainerName() + "!\n");
            loggedTrainer.getPokemons()
                    .forEach(System.out::println);
        }
        else {
            System.out.println("Incorrect login credentials.");
        }
    }

    public void setController(LoginController controller){
        this.controller = controller;
    }

}
