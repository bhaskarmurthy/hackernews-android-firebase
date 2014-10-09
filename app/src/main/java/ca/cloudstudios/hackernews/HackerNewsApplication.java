package ca.cloudstudios.hackernews;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import ca.cloudstudios.hackernews.modules.AndroidModule;
import dagger.ObjectGraph;
import timber.log.Timber;

/**
 * Created by bhaskar on 2014-10-08.
 */
public class HackerNewsApplication extends Application {
    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }

        graph = ObjectGraph.create(getModules().toArray()); // load dagger modules
    }

    protected List<Object> getModules() {
        ArrayList<Object> modules = new ArrayList<Object>();
        modules.add(new AndroidModule(this));
        return modules;
    }

    public void inject(Object o) {
        graph.inject(o);
    }
}
