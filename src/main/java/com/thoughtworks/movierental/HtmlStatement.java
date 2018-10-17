package com.thoughtworks.movierental;

class HtmlStatement {
  public String create(Rentals rentals, String name) {
    String result = "<h1>Rental Record for " + "<b>"+ name + "<b/>" + "</h1>" + "<br/>";

    for (Rental rental : rentals) {
      //show figures for this rental
      result += rental.getMovie().getTitle() + " " +
              String.valueOf(rental.amount()) + "<br/>";

    }

    //add footer lines result
    result += "Amount owed is " + "<b>" + String.valueOf(rentals.totalAmount()) + "<b/>" + "<br/>";
    result += "You earned " + "<b>" + String.valueOf(rentals.totalFrequentRenterPoints()) + "<b/>"
            + " frequent renter points";
    return result;
  }
}
