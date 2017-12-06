package com.sysgears.example.domain

import java.sql.Timestamp

import scala.slick.driver.H2Driver.simple._
import java.sql.Date
import org.joda.time.DateTime

/**
 * Customer entity.
 *
 * @param id        unique id
 * @param firstName first name
 * @param lastName  last name
 * @param birthday  date of birth
 */
case class Customer(id: Option[Long], firstName: String, lastName: String, birthday: Option[org.joda.time.DateTime])
case class SearchBirthdate(beginDate: Option[org.joda.time.DateTime], endDate: Option[org.joda.time.DateTime])
/**
 * Mapped customers table object.
 */
object Customers extends Table[Customer]("customers") {

  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def firstName = column[String]("first_name")

  def lastName = column[String]("last_name")

  def birthday = column[org.joda.time.DateTime]("birthday", O.Nullable)

  def * = id.? ~ firstName ~ lastName ~ birthday.? <>(Customer, Customer.unapply _)

 /* implicit val dateTypeMapper = MappedTypeMapper.base[java.util.Date, java.sql.Timestamp](
  {
    dt => new java.sql.Timestamp(dt.getTime)
  }, {
    t => new java.util.Date(t.getTime)
  })
*/
  implicit def dateTypeMapper  =
    MappedTypeMapper.base[org.joda.time.DateTime, Timestamp](
      { dateTime => new java.sql.Timestamp(dateTime.getMillis) },
      { date => new org.joda.time.DateTime(date.getTime) }
    )


  val findById = for {
    id <- Parameters[Long]
    c <- this if c.id is id
  } yield c
}