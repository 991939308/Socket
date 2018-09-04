package anonymity;

public class interiorClass {
    public static void main(String args[]){
        anonymity();
        lambdainterior();
    }

    public interface People{
        public void send();
    }

    public static void lambdainterior(){
        People people = ()->{
            System.out.println("lambda表达式代替匿名内部类");
        };
        people.send();
    }

    public static void anonymity(){
        People people = new People(){
            @Override
            public void send() {
                System.out.println("匿名内部类形式实现接口");
            }
        };
        people.send();
    }
}
