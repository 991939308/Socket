package Thread;

public class Thread_Runnable {
    public interface prople{
        public void send();
    }
        public static void main(String args[]){

//      1.妖艳贱货版本写法--匿名内部类
            new Thread(new Runnable(){
                @Override
                public void run() {
                    System.out.println("匿名内部类实现多线程");
                }
            }).start();
//      2.使用lambda表达式实现Runnable接口
            Runnable runnable = ()->{
                System.out.println("lambda表达式实现Runnable多线程");
            };
//      3.  Thread对象实现启动多线程
            new Thread(runnable).start();
//      4.
            new Thread(() -> System.out.println("In Java8, Lambda expression")).start();

        }

}
