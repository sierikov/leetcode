lazy val root = project
  .in(file("."))
  .settings(
    name := "leetcode",
    moduleName := "leetcode",
    description := "Collection of solutions to leetcode problems",
    version := "0.0.2",
    scalaVersion := "3.3.2",
    scalacOptions ++= Seq("-deprecation", "-feature"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )

addCommandAlias("check", ";scalafmtCheck;Test / scalafmtCheck")
