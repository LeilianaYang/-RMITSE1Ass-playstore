public class Magazine extends Reading {
    private String title;

    /*class-magazine的构造函数，因为需要调用所以一定要有构造函数*/
    public Magazine(String ID, String appName, int price, String publisher, String genre, int pages,String title ){
        super(ID, appName, price, publisher, genre, pages);
        this.title = title;
    }

    public String getTitle() { return title; }
}

    /*方法重写 在这里具体化重写method-addReviews
    * 带一个comment类型的参数叫cmnt
    * 然后这个参数调用method-getReview*/
    @Override
    public void addReviews(Comment cmnt) {
        // TODO Auto-generated method stub
        this.getReview().add(cmnt);
        System.out.println(cmnt.getWriter().getUname() + " added review \""
                + cmnt.getComment() + "\" on Magazine" + this.getApplication_name());
    }

    /*同理方法重写 具体化method-printAllReview
    * 初始化deep
    */
    @Override
    public void printAllReview() {
        // TODO Auto-generated method stub
        int deep = 0;
        System.out.println("The reviews of Magazine"+this.getApplication_name() + "-");

        /*循环
        * */
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
