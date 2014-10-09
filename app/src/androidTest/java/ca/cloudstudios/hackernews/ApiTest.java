package ca.cloudstudios.hackernews;

import android.test.ApplicationTestCase;

import javax.inject.Inject;

import ca.cloudstudios.hackernews.models.Item;
import ca.cloudstudios.hackernews.models.User;

/**
 * Created by bhaskar on 2014-10-08.
 */
public class ApiTest extends ApplicationTestCase<HackerNewsTestApplication> {
    private static final String TAG = "ApiTest";

    public ApiTest() {
        super(HackerNewsTestApplication.class);
    }

    @Inject
    HackerNewsService service;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        createApplication();
        getApplication().inject(this);
    }

    public void testGetItem() {
        final long id = 8422599;

        Item item = service.getItem(id)
                .toBlocking()
                .single();

        assertNotNull("Item should not be null", item);
        assertEquals("Item id should match", id, item.id);
    }

    public void testGetUser() {
        final String id = "kevin";

        User user = service.getUser(id)
                .toBlocking()
                .single();

        assertNotNull("Item should not be null", user);
        assertEquals("Item id should match", id, user.id);
    }
}
