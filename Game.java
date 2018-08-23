/* As reqiured class-Game is the subclass for class-Content
 * As required encapsulation the class-Game,make all the attribute as private
 * and construct the method-get 因为变成了私有的属性，所以需要一个get方法做调用每一个属性*/
public class Game extends Content {
    private boolean isMultiPlayer;
    private OS Gos;

    /* 实例化的过程就是 调用这个类的构造函数 创建一个具体的实例对象
     * super（）里面就是调用父类里的属性
     * this（）是调用上面的自身的
     */
    public Game(String ID, String appName, int price, boolean isMultiPlayer, OS Gos)
    {
        /* 根据classA.1 里面的例子写出构造函数需要参数，然后没有的参数在父类里写构造函数传参
         * 使用super调用父类，可以不用重复使用this调用
         */
        super(ID, appName, price);
        this.isMultiPlayer = isMultiPlayer;
        this.Gos = Gos;
    }

    /* constructor-Game 可以有很多个构造函数 但是参数的种类和个数不一样 一定要不一样 因为后面的调用 要保持参数一致*/
    public Game(String ID, String appName, boolean isMultiPlayer, OS OperateSystem)
    {
        super(ID, appName);
        this.isMultiPlayer = isMultiPlayer;
        this.Gos = OperateSystem;
    }

    public boolean isMultiPlayer() { return isMultiPlayer; }

    public OS getGos() { return Gos; }

    /* a user can be added to a content type of object
     * override 指的是方法重写 */
    @Override
    public void addReviews(Comment cmnt2) {

        this.getReview().add(cmnt2);
        System.out.println(cmnt2.getWriter().getName() + " added review \""
                + cmnt2.getComment() + "\" on Book" + this.getApplication_name() );

    }
}
