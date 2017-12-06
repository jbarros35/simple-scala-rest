import AssemblyKeys._

name := "rest"

version := "1.0"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
    "io.spray" % "spray-can" % "1.1-M8",
    "io.spray" % "spray-http" % "1.1-M8",
    "io.spray" % "spray-routing" % "1.1-M8",
    "net.liftweb" %% "lift-json" % "2.5.1",
    "com.typesafe.slick" %% "slick" % "1.0.1",
    "com.h2database" % "h2" % "1.4.195",
    "com.typesafe.akka" %% "akka-actor" % "2.1.4",
    "com.typesafe.akka" %% "akka-slf4j" % "2.1.4",
    "ch.qos.logback" % "logback-classic" % "1.0.13",
    //"com.github.nscala-time" %% "nscala-time" % "0.2.0",
    "joda-time" % "joda-time" % "1.6.2",
    "org.joda" % "joda-convert" % "1.8",
    "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

resolvers ++= Seq(
    "Spray repository" at "http://repo.spray.io",
    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
    "central" at "http://repo1.maven.org/maven2/"
)

assemblySettings
