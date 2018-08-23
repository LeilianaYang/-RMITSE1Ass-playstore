import java.util.HashMap;

public class User {
    private String ID;
    private String Uname;
    private String phoneNum;
    private int balance;
    private OS Uos;
    /*这里定义的hashmap是因为每一个user都需要一个购物列表来记录买的东西，所以程序里面需要一块地方来存储这个列表信息，
    所以hashmap形式是大腿觉得是最好的*/
    private HashMap<String, Content> contentList = new HashMap<String, Content>();

    /*这里设置一个布尔值就是为了判断是否成为了会员，程序里需要一块地方来存储会员的判断*/
    private boolean isPremium;//default value is false; check it before buying contents

    /*构造函数放在这里为了把抽象的对象实例化对象，this就是调用上面抽象的对象 被赋值 后面具体的对象*/
    public User(String ID, String Uname, String phoneNum, int balance, OS Uos, boolean isPremium) {
        this.ID = ID;
        this.Uname = Uname;
        this.phoneNum = phoneNum;
        this.balance = balance;
        this.Uos = Uos;
        this.isPremium = isPremium;
    }

    /* 封装：获取那些private的对象Accessor
     * 封装的意思 把属性变为private 然后再用get（）方法调用  */
    public String getID() {
        return ID;
    }

    public String getUname() {
        return Uname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public OS getUos() {
        return Uos;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isPremium() {
        return isPremium;
    }


    public void becomePremium() {

        /* 用if判断 余额是否多余100元
         * 再判断一下是否是会员 定义为true
         */
        try {
            if (this.balance >= 100) {
                this.balance -= 100;
                this.isPremium = true;
                System.out.println(this.Uname + " is now premium user!");

            }
            /*如果连100块都没有就不能成为会员*/
            else {
                NonEnoughException e = new NonEnoughException(this.Uname +
                        " is cannot become premium user due to insuffiecient fund!");
                throw e;

            }
            /* catch异常然后用父类的getMessage（）得到实例化e的内容 */
        } catch (NonEnoughException e) {
            System.out.println(e.getMessage());
        }
    }

    /* 构造一个buyContent的方法传参数（content类型）*/
    public void buyContent(Content o2) {
        double price = o2.getPrice();
        String name = o2.getApplication_name();

        /*object instanceof constructor 测试o2是不是在game这个类里 */

            if (o2 instanceof Game) {
                /*  定义一个Game类型的game，然后被赋值
                 * （game）打了括号就是强制转换，强制转化o2为Game类型*/
                Game game = (Game) o2;
                name = game.getApplication_name() + " for " + game.getGos().getOperatingSys();

            /*如果 user的Uos调用OS类里的getOperatingSys ，
            然后 用游戏调用getGos（）在调用getOperatingSys（）来验证 是不是游戏系统
            如果不是，！= ，实例化异常，并抛出异常 */
            try {
                if (this.Uos.getOperatingSys() != game.getGos().getOperatingSys()) {
                    NonSuitableException e = new NonSuitableException(this.Uname + " cannot buy " +
                            name + " due to OS mismatch.");
                    throw e;
                    /* 调用getVersionNum() 判断 这个Uos的版本信息 是不是高于game的 版本信息
                     *  如果 小于的话 则实例化异常"。。。"，并抛出异常*/
                } else if (this.Uos.getVersionNum() < game.getGos().getVersionNum()) {
                    NonSuitableException e = new NonSuitableException(name + " requires " +
                            game.getGos().getOperatingSys() + " version " + game.getGos().getVersionNum()
                            + " at least.");
                    throw e;
                }
                /*在这个try catch分界线 抛出异常 打印异常*/

            }catch (NonSuitableException e) {
                System.out.println(e.getMessage());
        }
        /* 会员打八折 如果这个会员的价钱 是buyContent里面的参数o2 可以调用getPrice方法 打八折 */
        }if (this.isPremium) price = o2.getPrice()* 0.8;
            /* try 捕捉异常 如果这个余额 是不是大于价钱 */
            try {
                if (this.balance >= price) {
                    this.balance -= price;

                    /* 每买一样东西都会有一个contentlist
                     * put方法是 把后面的东西放进contentList（是一个hashmap）去 后面的getID方法 就是hashmap的key值，o2是value值*/
                    contentList.put(o2.getID(), o2);

                    /* o2 调用increaseNumOfDownload方法 每下载一个东西都会多一个下载项目*/
                    o2.increaseNumOfDownload();
                    System.out.println(this.Uname + " bought " + name);
                } else {
                    /*实例化NonEnoughException 然后抛出异常*/
                    NonEnoughException e = new NonEnoughException(this.Uname + " cannot buy " + name + " due to insuffiecient fund!");
                    throw e;

                }
                /* catch NonEnoughException 异常 用get方法调用异常的内容 */
            }catch (NonEnoughException e) {
                    System.out.println(e.getMessage());
                }

            }








    public void showContentsBought() {
        // TODO Auto-generated method stub
        /*show the list of names of all the contents that the user bought*/
        System.out.println("The contents bought by "+this.Uname+" - ");

        /* for 从句 里面冒号表示 Sting s 在this.contentList（因为是hashmap）
        调用了keySet方法  循环
         * 给String类型的 name赋值 get（s）方式是这个购物清单的key值
         * getApplication_name()是hashmap的value */
        for(String s : this.contentList.keySet())
        {
            String name = this.contentList.get(s).getApplication_name();

            /*这个再做一个判断
            如果这个商品属于一个游戏
            实例化这个商品为 名字+for+调用商品具有系统 且有操作系统
            输出商品 */
            if( this.contentList.get(s) instanceof Game)
            {
                Game game = (Game)this.contentList.get(s);
                name = game.getApplication_name() + " for " + game.getGos().getOperatingSys();
            }
            System.out.println(name);
        }
    }



}
