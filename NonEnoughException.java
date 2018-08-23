
/* 这里是新写一个异常类 但是这个异常类必须是 继承了父类Exception的所有方法　
 * 然后写构造（函数）方法 传参数（string类型因为在class-user里面捕捉的异常）*/
public class NonEnoughException extends Exception {
    public NonEnoughException(String message){
        super(message);
    }
}
