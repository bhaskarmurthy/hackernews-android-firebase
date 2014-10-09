package ca.cloudstudios.hackernews.models;

import org.joda.time.DateTime;

/**
 * Created by bhaskar on 2014-10-08.
 */
public class Item {
    public long id;
    public String type;
    public String url;

    public String title;

    public int score;
    public long[] kids; // comments

    public String by;
    public DateTime time;
}
