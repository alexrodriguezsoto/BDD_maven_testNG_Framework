package step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import utilities.CucumberLogUtils;
import utilities.Driver;
import utilities.ScenarioContext;
import utilities.SetEnvironment;

public class Hook {

    @Before(order = 1)
    public void genericSetUp(Scenario scenario){
        ScenarioContext.scenario.set(scenario);
        CucumberLogUtils.scenarioResult = true;
        Driver.getInstance().get(SetEnvironment.getEnvironmentUrl());
    }
}
