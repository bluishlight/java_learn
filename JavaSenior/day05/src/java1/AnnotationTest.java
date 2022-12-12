package java1;

import java.lang.annotation.Annotation;

public class AnnotationTest {
    public static void main(String[] args) {
        Haha haha;
        haha = new Haha();
        Annotation[] list = haha.getClass().getDeclaredAnnotations();
        for(Annotation a: list){
            System.out.println(a);
        }
        @MyRuntimeAnnotation int k = 1;
        System.out.println(k);
    }



// Rentation: SOURCE CLASS(默认 编译有 运行没有)   RUNTIME 可被反射加载
}
