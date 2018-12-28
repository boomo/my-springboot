package com.hly.chapter221;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        Binder binder = Binder.get(context.getEnvironment());

        Foo foo = binder.bind("com.hly", Bindable.of(Foo.class)).get();
        System.out.println(foo.getFoo());

        List<String> citys = binder.bind("com.hly.city", Bindable.listOf(String.class)).get();

        System.out.println(citys);


        List<Food> foods = binder.bind("com.hly.food", Bindable.listOf(Food.class)).get();
        System.out.println(foods);

        Map<String, String> sMap = binder.bind("com.hly.student", Bindable.mapOf(String.class, String.class)).get();
        System.out.println(sMap);


        System.out.println(context.getEnvironment().containsProperty("com.hly.s-df"));
        System.out.println(context.getEnvironment().containsProperty("com.hly.s_df"));
        System.out.println(context.getEnvironment().containsProperty("com.hly.s.df"));

    }
}
