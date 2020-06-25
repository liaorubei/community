package com.fylx;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.fylx.entity.User;
import com.fylx.mapper.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
/*        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("Hello World!");*/
        //中文中文
        List<User> list = new ArrayList<>();
        Export(list, User.class);
    }


    public static <T> void Export(List<T> list, Class<T> c) {
        // c.get

        System.out.println("");
    }
}
