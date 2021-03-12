import PlayCrossCompilation._
import sbt.Keys.scalaVersion
import uk.gov.hmrc.{SbtArtifactory, SbtAutoBuildPlugin}

lazy val root = Project("platops-example-library", file("."))
  .enablePlugins(SbtAutoBuildPlugin, SbtGitVersioning)
  .settings(
    makePublicallyAvailableOnBintray := true,
    majorVersion              := 0,
    playCrossCompilationSettings,
    scalaVersion              := "2.12.13",
    libraryDependencies       ++= compileDependencies ++ testDependencies,
  )

val compileDependencies = dependencies(
  play26 = Seq("com.typesafe.play" %% "play-json" % "2.6.8"),
  play27 = Seq("com.typesafe.play" %% "play-json" % "2.7.4"),
  play28 = Seq("com.typesafe.play" %% "play-json" % "2.8.1")
)

val testDependencies = Seq(
  "org.scalatest"        %% "scalatest"    % "3.2.6"   % Test,
  "com.vladsch.flexmark" %  "flexmark-all" % "0.35.10" % Test
)
