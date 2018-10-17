package com.thoughtworks.movierental;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {
    @Test
    public void verifyTheStatementIsGeneratedCorrectly(){
        Customer customer  = new Customer("user1");
        assertEquals(customer.getName(),"user1");
        customer.addRental(new Rental(new Movie("movie1",Movie.CHILDRENS),3));
        customer.addRental(new Rental(new Movie("movie2",Movie.NEW_RELEASE),5));
        customer.addRental(new Rental(new Movie("movie1",Movie.REGULAR),1));
        assertEquals("Rental Record for user1\n" +
                "\tmovie1\t1.5\n" +
                "\tmovie2\t15.0\n" +
                "\tmovie1\t2.0\n" +
                "Amount owed is 18.5\n" +
                "You earned 4 frequent renter points",customer.statement());


    }

    @Test
    public void verifyTheStatementIsGeneratedCorrectlyInHtml(){
        Customer customer  = new Customer("user1");
        assertEquals(customer.getName(),"user1");
        customer.addRental(new Rental(new Movie("movie1",Movie.CHILDRENS),3));
        customer.addRental(new Rental(new Movie("movie2",Movie.NEW_RELEASE),5));
        customer.addRental(new Rental(new Movie("movie1",Movie.REGULAR),1));
        assertEquals("<h1>Rental Record for <b>user1<b/></h1><br/>" +
                "movie1 1.5<br/>" +
                "movie2 15.0<br/>" +
                "movie1 2.0<br/>" +
                "Amount owed is <b>18.5<b/><br/>" +
                "You earned <b>4<b/> frequent renter points",customer.htmlStatement());
    }

}