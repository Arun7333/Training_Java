package org.java_based.example;

import org.models.Engine;
import org.models.Vehicle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.xml_based.Bike;

@Component
public class Car implements Vehicle, BeanNameAware, ApplicationContextAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private Engine engine;
    private Bike bike;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Autowired
    public void setBike(Bike bike) {
        this.bike = bike;
    }

    @Override
    public void start() {
        System.out.println("car started..");
        engine.start();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("name  " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("context  " + applicationContext);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("bean factory  " + beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("implemented init");
    }

    //Post construct not working
    public void init(){
        System.out.println("annotated init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("implementation destroy");
    }
}
