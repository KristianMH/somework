import sbt._
import Keys._

object Common {
  val settings: Seq[Setting[_]] = Seq(
    organization := "TBA",
    version := "1.2.3-SNAPSHOT",
    scalaVersion := "2.11.11"
  )

  val sco = scalacOptions ++= Seq("-feature", "-deprecation", "-unchecked", "-language:reflectiveCalls", "-language:postfixOps",
                                  "-language:implicitConversions")

  val playSettings  = settings ++ Seq(
    libraryDependencies ++= Seq(
      "org.specs2" %% "specs2-matcher-extra" % "3.8.5" % Test,
      "com.typesafe.play" %% "play-slick" % "2.0.0",
      "org.postgresql" % "postgresql" % "42.1.1",
      "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test
    ),
    resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
  )
}
