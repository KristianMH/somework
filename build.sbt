name := """driveedu"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

scalacOptions ++= Seq("-feature", "-deprecation", "-unchecked", "-language:reflectiveCalls", "-language:postfixOps", "-language:implicitConversions")

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalariformSettings

libraryDependencies ++= Seq(
  specs2 % Test,
  "org.specs2" %% "specs2-matcher-extra" % "3.8.5" % Test,
"com.typesafe.play" %% "play-slick" % "2.0.0",
  "org.postgresql" % "postgresql" % "42.1.1",
  filters,
"org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test
)
// Adds additional packages into Twirl
//TwirlKeys.templateImports += "hello.com.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "hello.com.binders._"
herokuAppName in Compile := "powerful-lowlands-81849"
herokuJdkVersion in Compile := "1.8"

herokuProcessTypes in Compile := Map(
  "web" -> "target/universal/stage/bin/driveedu -Dhttp.port=$PORT"
)
herokuAppName in Compile := Map(
  "testing"    -> "myapp-testing",
  "staging"    -> "myapp-staging",
  "production" -> "myapp"
).getOrElse(git.gitCurrentBranch.value, "myapp-dev")

showCurrentGitBranch
