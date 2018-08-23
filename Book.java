public class Book extends Reading {
    private String[] author;

    public Book(String ID, String appName, int price, String publisher, String genre, int pages, String[] author) {

        super(ID, appName, price, publisher, genre, pages);
        this.author = author;
    }

    public String[] getAuthor() {
        return author;
    }

    /*方法重写 调用了getReview() 给书添加review*/
    @Override
    public void addReviews(Comment cmnt2) {

        this.getReview().add(cmnt2);
        System.out.println(cmnt2.getWriter().getUname() + " added review \""
                + cmnt2.getComment() + "\" on Book" + this.getApplication_name());
    }

    /* */
    @Override
    public void printAllReview() {
        // TODO Auto-generated method stub
        int deep = 0;
        System.out.println("The reviews of Book "+this.getApplication_name() + "-");
        for(int i = 0; i < this.getReview().size(); i++)
        {
            System.out.println(this.getReview().get(i).getWriter().getUname()+ " ("+
                    this.getReview().get(i).getWriter().getID()+"): "+
                    this.getReview().get(i).getComment());
            if(!this.getReview().get(i).getReplyCmnt().isEmpty()) {
                deep++;
                this.printReply(this.getReview().get(i), deep);
                deep--;
            }
        }
    }

    public void printReply(Comment cmnt, int deep) {
        for(int i = 0; i < cmnt.getReplyCmnt().size(); i++) {
            for(int j = 0; j < deep; j++)
            {
                System.out.print("\t");
            }
            System.out.println(cmnt.getReplyCmnt().get(i).getWriter().getUname()+ " ("+
                    cmnt.getReplyCmnt().get(i).getWriter().getID()+"): "+
                    cmnt.getReplyCmnt().get(i).getComment());
            if(!cmnt.getReplyCmnt().get(i).getReplyCmnt().isEmpty())
            {
                deep++;
                printReply(cmnt.getReplyCmnt().get(i), deep);
                deep--;
            }
        }
    }
}