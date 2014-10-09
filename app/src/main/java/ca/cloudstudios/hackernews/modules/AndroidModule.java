package ca.cloudstudios.hackernews.modules;

import android.content.Context;

import com.firebase.client.Firebase;

import javax.inject.Singleton;

import ca.cloudstudios.hackernews.HackerNewsApplication;
import ca.cloudstudios.hackernews.HackerNewsService;
import ca.cloudstudios.hackernews.R;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bhaskar on 2014-10-05.
 */
@Module(
        injects = {
                Firebase.class,
                HackerNewsService.class
        },
        library = true
)
public class AndroidModule {
    private final HackerNewsApplication application;

    public AndroidModule(HackerNewsApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    Firebase provideFirebase() {
        Firebase.setAndroidContext(application);
        return new Firebase(application.getString(R.string.firebase_url));
    }

    @Provides
    @Singleton
    HackerNewsService provideService() {
        HackerNewsService service = new HackerNewsService();
        application.inject(service);

        return service;
    }
}
