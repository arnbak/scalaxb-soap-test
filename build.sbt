import ScalaxbKeys._

name := "soap-example"

organization := "dk.invokers"

scalaVersion := "2.11.7"

lazy val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
lazy val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"
lazy val dispatchV = "0.11.2"
lazy val dispatch = "net.databinder.dispatch" %% "dispatch-core" % dispatchV

libraryDependencies ++= Seq(
  "org.scalaxb" % "scalaxb_2.11" % "1.4.0",
  dispatch,
  scalaXml,
  scalaParser
)

scalaxbSettings

//packageName in scalaxb in Compile := "com.keysurvey.api"

sourceGenerators in Compile <+= scalaxb in Compile

dispatchVersion in (Compile, scalaxb) := dispatchV

async in (Compile, scalaxb)           := true

packageName in (Compile, scalaxb)     := "com.keysurvey.api"