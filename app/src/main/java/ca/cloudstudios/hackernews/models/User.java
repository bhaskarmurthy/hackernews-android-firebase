package ca.cloudstudios.hackernews.models;

import org.joda.time.DateTime;

/**
 * Created by bhaskar on 2014-10-08.
 */
public class User {
    public String id;
    public String about;

    public int karma;
    public long[] submitted;

    public DateTime created;
    public int delay;
}
