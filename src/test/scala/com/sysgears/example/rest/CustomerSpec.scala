package com.sysgears.example.rest

import java.sql.Timestamp

import com.sysgears.example.dao.CustomerDAO
import com.sysgears.example.domain.{Customer, CustomerSearchParameters, SearchBirthdate}
import org.scalatest._
import org.scalatest.Matchers._
import org.joda.time._

class CustomerSpec extends FlatSpec {

  val customerService = new CustomerDAO
  val time = new java.util.Date().getTime
  val birthdate = Option(new org.joda.time.DateTime(time))
  val searchDate = Option(new org.joda.time.DateTime(time))

  "A CustomerService" should "insert new customer" in {
    val customerCreated = customerService.create(Customer(Option(1L), "CUSTOMER#1", "LASTNAME", birthdate))
    customerCreated.right.get shouldBe a [Customer]
  }

  "a CustomerService" should "find the customer" in {
    val findCustomer = customerService.get(1L)
    findCustomer.right.get shouldBe a [Customer]
    findCustomer.right.get.firstName shouldBe "CUSTOMER#1"
    findCustomer.right.get should have (
      'firstName("CUSTOMER#1"),
      'lastName("LASTNAME")
    )
  }

  "A CustomerService" should "find customer with FIRSTNAME" in  {
    val found = customerService.search(CustomerSearchParameters(Option("CUSTOMER#1"), None, None)).right.get
    found should have size (1)
  }

  "A CustomerService" should "find customer with LASTNAME" in  {
    val found = customerService.search(CustomerSearchParameters(None, Option("LASTNAME"), None)).right.get
    found should have size (1)
  }

  "A CustomerService" should "find customer with birthdate" in  {
    val found = customerService.search(CustomerSearchParameters(None, None, searchDate)).right.get
    found should have size (1)
  }

  "A CustomerService" should "find customer with birthdate range" in  {
    customerService.searchByBirthDate(SearchBirthdate(Option(new DateTime(2017, 12, 1, 0, 0, 0, 0)), Option(new DateTime(2017, 12, 31, 0, 0, 0, 0)))).right.get should have size (1)
   // customerService.searchByBirthDate(SearchBirthdate(None, None)).right.get should have size (1)
   // customerService.searchByBirthDate(SearchBirthdate(birthdate, None)).right.get should have size (1)
  }

}
