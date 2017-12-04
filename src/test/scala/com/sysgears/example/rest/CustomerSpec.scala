package com.sysgears.example.rest

import com.sysgears.example.dao.CustomerDAO
import com.sysgears.example.domain.Customer
import org.scalatest._
import org.scalatest.Matchers._

class CustomerSpec extends FlatSpec {

  val customerService = new CustomerDAO

  "A CustomerService" should "insert new customer" in {
    val customerCreated = customerService.create(Customer(Option(1L), "CUSTOMER#1", "LASTNAME", Option(new java.util.Date())))
    customerCreated.right.get shouldBe a [Customer]
  }

  "a CustomerService" should "find the customer" in {
    val findCustomer = customerService.get(1L)
    findCustomer.right.get shouldBe a [Customer]
    findCustomer.right.get.firstName shouldBe "CUSTOMER#1"
  }

}
