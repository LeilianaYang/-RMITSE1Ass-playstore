/* reading子类继承父类Content*/
public abstract class Reading extends Content {
  private String publisher;
  private String genre;
  private int pages;

  /*这个是class-book的父类的构造函数*/
  public Reading(String ID, String appName, int price,String publisher, String genre, int pages){
    super(ID,appName,price);
    this.publisher = publisher;
    this.genre     = genre;
    this.pages     = pages;
  }

  /*这个是class-magazine的父类的构造函数*/
  public Reading(String ID, String appName, int numOfDownload, int price, String publisher, String genre, int numOfPage)
  {
    super(ID, appName, numOfDownload, price);
    this.publisher = publisher;
    this.genre = genre;
    this.pages = numOfPage;
  }

  /*这个是 class-magazine 和 class-book的父类的构造函数*/
  public Reading(String ID, String appName, String publisher, String genre, int numOfPage)
  {
    super(ID, appName);
    this.publisher = publisher;
    this.genre = genre;
    this.pages = numOfPage;
  }
  public String getPublisher() { return publisher; }

  public String getGenre() { return genre; }

  public int getPages() { return pages; }
}

