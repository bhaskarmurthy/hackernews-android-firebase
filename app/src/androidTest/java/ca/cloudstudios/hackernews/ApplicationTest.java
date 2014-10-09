package ca.cloudstudios.hackernews;

import android.test.ApplicationTestCase;

import com.firebase.client.Firebase;

import javax.inject.Inject;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<HackerNewsTestApplication> {
    public ApplicationTest() {
        super(HackerNewsTestApplication.class);
    }

    @Inject Firebase firebase;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        createApplication();
        getApplication().inject(this);
    }

    public void testFirebase() {
        assertNotNull("Firebase must not be null", firebase);
    }
}