package ca.cloudstudios.hackernews;

import java.util.Arrays;
import java.util.List;

import ca.cloudstudios.hackernews.modules.AndroidModule;
import dagger.Module;

/**
 * Created by bhaskar on 2014-10-08.
 */
public class HackerNewsTestApplication extends HackerNewsApplication {
    @Override
    protected List<Object> getModules() {
        return Arrays.asList(
            new AndroidModule(this),
            new TestModule()
        );
    }

    @Module(
            injects = {
                    ApplicationTest.class,
                    ApiTest.class
            },
            complete = false
    )
    static class TestModule {}
}
