import com.typesafe.sbt.SbtGit._

name := """driveedu"""
organization := "hello.com"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

libraryDependencies += filters
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test

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