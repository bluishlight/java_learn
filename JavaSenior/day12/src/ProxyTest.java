import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface  Human{
    String getBelief();
    void eat(String food);
}
class SuperMan implements Human{
    public  String getBelief(){
        return "I FLY";
    }

    @Override
    public void eat(String food) {
        System.out.println("eat "+ food);
    }
}

class ProxyFactory{

    // 哪个类加载的，接口，
    public static Object getProxyInstance(Object obj){
        // 类的加载器
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }
}
class MyInvocationHandler implements InvocationHandler {

    private Object obj;// 被代理类的对象 实例化在handler.bind(obj);
    public void bind(Object obj){
        this.obj = obj;
    }
//    当通过被代理类调用方法时就调用如下的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("麻辣烫");
    }
}