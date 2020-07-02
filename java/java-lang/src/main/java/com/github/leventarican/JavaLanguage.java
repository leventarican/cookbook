package com.github.leventarican;

import com.github.leventarican.designpattern.factory.TheFactory;
import com.github.leventarican.designpattern.TheImmutable;
import com.github.leventarican.designpattern.iterator.TheIterator;
import com.github.leventarican.designpattern.factory.Car;
import com.github.leventarican.designpattern.iterator.IteratorDemo;


public class JavaLanguage {
    public static void main( String[] args ) throws Exception {
        System.out.println( "#############" );
        System.out.println( "java language" );
        System.out.println( "#############\n" );

//        LambdaExpression lambdaExpression = new LambdaExpression();
//        lambdaExpression.exec();
//
//        Collections collections = new Collections();
//        collections.exec();
//
//        Loops loops = new Loops();
//        loops.exec();
//
//        new Clazz().new MemberClass();
//        Clazz.StaticClass.whoami();
//        /*
//        inner class: LocalClass
//        inner class: anonymous
//        inner class: MemberClass
//        inner class: StaticClass
//        */
//
//        Exceptions exceptions = new Exceptions();
//        exceptions.exec();
//
//        BitsBytes bits = new BitsBytes();
//        bits.exec();
//
//        Objects objs = new Objects();
//        objs.exec();
//
//        Network network = new Network();
//        network.exec();
//
//        FileCreator file = new FileCreator();
//        file.exec();
//
//        SelectionSort selectionSort = new SelectionSort();
//        selectionSort.exec();

//        LoggingJUL jul = new LoggingJUL();
//        jul.exec();

//        DataStructures ds = new DataStructures();
//        ds.exec();
//        
//        TheImmutable im = new TheImmutable("python");
//        im.getProgrammingLang();
//        System.out.println(im.isJVMcomptabile());
//        
//        Car car = TheFactory.build();
//        System.out.println(car);
//        
//        IteratorDemo demo = new IteratorDemo();
//        demo.exec();

//        DataTypes dt = new DataTypes();
//        dt.exec();
        
//        Concurrency con = new Concurrency();
//        con.exec();

        Files f = new Files();
        f.exec();
    }
}
