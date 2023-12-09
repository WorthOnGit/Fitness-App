package use_case.RecipeSearchButton;

import use_case.RecipeDataAccessInterface;
import entity.Recipe;

import java.io.IOException;

public class RecipeSearchButtonInteractor implements RecipeSearchButtonInputBoundary {

    private final RecipeSearchButtonOutputBoundary presenter;

    private final RecipeDataAccessInterface dataAccess;

    private final Recipe recipe = null;

    public RecipeSearchButtonInteractor(RecipeSearchButtonOutputBoundary presenter, RecipeDataAccessInterface dataAccess) {
        this.presenter = presenter;
        this.dataAccess = dataAccess;
    }


    @Override
    public void execute(RecipeSearchInputData inputData) {
        if (inputData.noInput()) {
            presenter.presentnoinputfail();
            return;
        }

        try {
            Recipe recipe = dataAccess.getRecipe(
                    inputData.getRecipeName(),
                    inputData.getCountryOfOrigin(),
                    inputData.getCalories(),
                    inputData.getDietLabels(),
                    inputData.getHealthLabels(),
                    inputData.getMealType());
            presenter.presentrecipe(recipe);

        } catch (RuntimeException e) {
            e.printStackTrace();  // Add this line to print the exception details
            presenter.presentnoresultfail();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}