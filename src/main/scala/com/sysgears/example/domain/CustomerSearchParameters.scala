package com.sysgears.example.domain

import java.util.Date
import org.joda.time.DateTime

/**
 * Customers search parameters.
 *
 * @param firstName first name
 * @param lastName  last name
 * @param birthday  date of birth
 */
case class CustomerSearchParameters(firstName: Option[String] = None,
                                    lastName: Option[String] = None,
                                    birthday: Option[org.joda.time.DateTime] = None)