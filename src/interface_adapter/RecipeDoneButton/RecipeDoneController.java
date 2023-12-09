package interface_adapter.RecipeDoneButton;
import use_case.RecipeDoneButton.RecipeDoneInputBoundary;

public class RecipeDoneController {

    final RecipeDoneInputBoundary recipeCancelInputBoundary;

    public RecipeDoneController(RecipeDoneInputBoundary recipeCancelInputBoundary) {

        this.recipeCancelInputBoundary = recipeCancelInputBoundary;
    }

    public void execute() {

        recipeCancelInputBoundary.execute();
    }

}