package calculator.model;

import calculator.model.configuration.Config;
import calculator.model.observer.CalculatorObserver;
import calculator.view.localization.Language;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {

    private static final int MAX_BASE = 16;

    private CalculatorObserver calculatorObserver;

    public void setCalculatorObserver(CalculatorObserver calculatorObserver) {
        this.calculatorObserver = calculatorObserver;
    }

    public void updateDigitButtons(int base) {
        List<String> buttonsToUpdate = new ArrayList<>(MAX_BASE - base);
        for (int i = base; i < MAX_BASE; ++i) {
            buttonsToUpdate.add(Integer.toString(i, 16).toUpperCase());
        }
        calculatorObserver.updateDigitButtons(buttonsToUpdate);
    }

    public void setLanguageToConfig(Language language) {
        Config.setLanguage(language);
    }

    public void setCalculatorModeToConfig(CalculatorMode calculatorMode) {
        Config.setCalculatorMode(calculatorMode);
        calculatorObserver.updateCalculatorMode(calculatorMode);
    }

    public void readConfigInformation() {
        calculatorObserver.updateCalculatorMode(Config.getCalculatorMode());
    }

    public void readLanguageFromConfig() {
        calculatorObserver.updateLanguage(Config.getLanguage());
    }
}
