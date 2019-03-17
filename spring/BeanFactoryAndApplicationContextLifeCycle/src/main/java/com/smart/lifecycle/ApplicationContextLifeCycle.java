package com.smart.lifecycle;

import com.smart.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zwxbest on 2018/3/5.
 */
public class ApplicationContextLifeCycle {

    private static void LifeCycleInBeanFactory(){

//       ①下面两句装载配置文件并启动容器
       ApplicationContext bf=new ClassPathXmlApplicationContext("com/smart/context/beans.xml");

        //④第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用。
        Car car1 = (Car)bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        //⑤第二次从容器中获取car，直接从缓存池中获取
        Car car2 = (Car)bf.getBean("car");

        //⑥查看car1和car2是否指向同一引用
        System.out.println("car1==car2:"+(car1==car2));

    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
