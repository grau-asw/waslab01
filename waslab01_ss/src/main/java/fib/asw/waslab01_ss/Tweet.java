package fib.asw.waslab01_ss;

public class Tweet {
    private long twid;
    private String author;
    private String text;
    private java.sql.Timestamp created_at;

    public Tweet() {
    }

    // generate getters and setters
    public long getTwid() {
        return twid;
    }
    public void setTwid(long twid) {
        this.twid = twid;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public java.sql.Timestamp getCreated_at() {
        return created_at;
    }
    public void setCreated_at(java.sql.Timestamp created_at) {
        this.created_at = created_at;
    }
}
