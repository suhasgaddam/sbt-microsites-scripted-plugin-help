scalaVersion := "2.11.11"

name := "hello-world-microsite"
organization := "org.example"
version := "1.0"

libraryDependencies += "org.typelevel" %% "cats" % "0.9.0"

import sbtbuildinfo.BuildInfoPlugin.autoImport._

lazy val docs = (project in file("docs"))
  .settings(
    moduleName := "docs",
    scalaVersion := "2.11.11"
  )
  .enablePlugins(MicrositesPlugin)
  .settings(
    micrositeName := "sbt-microsites-scripted-plugin-help",
    micrositeDescription := "An sbt plugin to create awesome microsites for your project",
    micrositeBaseUrl := "sbt-microsites-scripted-plugin-help",
    micrositeDocumentationUrl := "/sbt-microsites-scripted-plugin-help/docs/",
    micrositeGithubOwner := "suhasgaddam",
    micrositeGithubRepo := "sbt-microsites-scripted-plugin-help",
    micrositeGithubToken := sys.env.get("GITHUB_TOKEN"),
    // micrositeGithubToken := None,
    micrositeHighlightTheme := "color-brewer",
    includeFilter in makeSite := "*.html" | "*.css" | "*.png" | "*.jpg" | "*.gif" | "*.js" | "*.swf" | "*.md"
  )
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "microsites"
  )
