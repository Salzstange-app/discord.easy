package net.sta.guild.reflection;


import org.reflections.Reflections;

import java.util.Arrays;
import java.util.Set;

public class MainAnnotation {


    public static void main(String[] args) {

        Reflections reflections = new Reflections("net.sta");

       // Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(reflections.getClass());

        System.out.println(Arrays.toString(reflections.getClass().getAnnotations()));

    }

}
