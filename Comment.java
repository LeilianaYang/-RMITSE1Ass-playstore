import java.util.ArrayList;
import java.util.List;

public class Comment {
    private User writeCmnt;
    private String comment;
    private List<Comment> reply = new ArrayList<Comment>();

    public Comment(User writeCmnt, String comment){
        this.writeCmnt = writeCmnt;
        this.comment   = comment;

    }

    public void addReply(Comment o5){
        this.reply.add(o5);
        System.out.println(o5.writeCmnt.getUname() +
                " replied" +
                "\n"+
                o5.comment + "\n" );


    }

    public User getWriter() { return writeCmnt; }

    public String getComment() { return comment; }
    public  List<Comment> getReplyCmnt() { return reply; }


}
