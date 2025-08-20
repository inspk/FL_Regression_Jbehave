package com.hhstechgroup.steps.jbehave;

import com.hhstechgroup.util.converters.ExamplesTableConverter;
import com.hhstechgroup.util.converters.SessionVariableConverter;
import net.serenitybdd.jbehave.SerenityStory;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.model.TableTransformers;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.steps.ParameterControls;

import java.util.Optional;

//import com.hhstechgroup.steps.jbehave.scenarios.IUFlowScenarios.AlternateIdentifierScenario;
//import org.jbehave.core.steps.InjectableStepsFactory;
//import org.jbehave.core.steps.InstanceStepsFactory;

public class AcceptanceTestSuite extends SerenityStory {

    public AcceptanceTestSuite() {
        super();
        Optional.ofNullable(System.getProperty("story")).ifPresent(this::findStoriesCalled);
        setUpConfiguration();
    }

    private void setUpConfiguration() {
        configuration().useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));
        configuration().usePendingStepStrategy(new FailingUponPendingStep());
        configuration().parameterConverters().addConverters(new SessionVariableConverter());
        configuration().parameterConverters()
                .addConverters(new ExamplesTableConverter(new ExamplesTableFactory(configuration().storyLoader(),
                        new TableTransformers())));
        configuration().useStoryParser(new RegexStoryParser(new ExamplesTableFactory(configuration().keywords(),
                new LoadFromClasspath(this.getClass()), configuration().tableTransformers())));
    }

//    @Override
//    public InjectableStepsFactory stepsFactory() {
//        return new InstanceStepsFactory(configuration(),
//                new AlternateIdentifierScenario()
//                // , add other scenario/step classes here as needed
//        );
//    }
}
