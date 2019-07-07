package com.github.leventarican;

public class JavaLanguage {
    public static void main( String[] args ) {
        System.out.println( "#############" );
        System.out.println( "java language" );
        System.out.println( "#############\n" );

        LambdaExpression lambdaExpression = new LambdaExpression();
        lambdaExpression.exec();

        Collections collections = new Collections();
        collections.exec();

        Loops loops = new Loops();
        loops.exec();

        new Clazz().new MemberClass();
        Clazz.StaticClass.whoami();
        /*
        inner class: LocalClass
        inner class: anonymous
        inner class: MemberClass
        inner class: StaticClass
        */

        Exceptions exceptions = new Exceptions();
        exceptions.exec();

    }
}
