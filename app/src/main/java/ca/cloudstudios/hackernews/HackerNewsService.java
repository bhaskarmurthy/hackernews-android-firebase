package ca.cloudstudios.hackernews;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import javax.inject.Inject;

import ca.cloudstudios.hackernews.models.Item;
import ca.cloudstudios.hackernews.models.User;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by bhaskar on 2014-10-09.
 */
public class HackerNewsService {
    @Inject
    Firebase ref;

    public Observable<Item> getItem(final long id) {
        return getValue("item", id, Item.class);
    }

    public Observable<User> getUser(final String id) {
        return getValue("user", id, User.class);
    }

    private <T, V> Observable<V> getValue(final String root, final T id, final Class<V> cls) {
        return Observable.create(new Observable.OnSubscribe<V>() {
            @Override
            public void call(final Subscriber<? super V> subscriber) {
                ref.child("/" + root + "/" + id)
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot data) {
                                V item = data.getValue(cls);
                                subscriber.onNext(item);
                                subscriber.onCompleted();
                            }

                            @Override
                            public void onCancelled(FirebaseError error) {
                                subscriber.onError(error.toException());
                                subscriber.onCompleted();
                            }
                        });

            }
        });
    }
}
