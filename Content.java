import java.util.ArrayList;
import java.util.List;

public abstract class Content {

   private String ID;
   private String application_name;
   private int downloads;
   private int price;
    private List<Comment> review= new ArrayList<Comment>();


    /* 根据子类的需求写以下三个构造函数 game子类里需要一个content（里面传了三个参数）*/
    public Content(String ID, String appName, int price)
    {

        this.ID = ID;
        this.application_name = appName;
        this.price = price;
        this.downloads = 0;
    }

    /*reading 子类需要一个content父类（带四个参数）*/
    protected Content(String ID, String appName, int numOfDownload, int price)
    {
        this.ID = ID;
        this.application_name = appName;
        this.downloads = numOfDownload;
        this.price = price;
    }

    /*both reading and game need 父类conntent（2个参数）*/
    protected Content(String ID, String appName) {
        // TODO Auto-generated constructor stub
        this.ID = ID;
        this.application_name = appName;
        this.price = 0;
        this.downloads = 0;
    }

    /*封装 由于attribute都是private的 所以要用method-get 调用*/
    public String getID() { return ID; }

    public String getApplication_name() { return application_name; }

    public int getDownloads() { return downloads; }

    public int getPrice() { return price; }

    /* increaseNumOfDownload() 每下载一个东西 下载列表 会加一个东西*/
    protected  void  increaseNumOfDownload(){ this.downloads += 1; }

    protected List<Comment> getReview() {
        return review; }

    /*只有在抽象类中才能有抽象方法，抽象类也可以有非抽象方法，
    但是如果抽象类里的抽象方法，必须仔非抽象类里的子类里进行方法重写 必须有方法体 必须具体
    但是 抽象类里的其他方法 还是要写方法体的 */
    public abstract void addReviews(Comment cmnt2);

    public abstract void printAllReview();
}







