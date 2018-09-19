import PlayCrossCompilation._
import sbt.Keys.scalaVersion
import uk.gov.hmrc.DefaultBuildSettings.targetJvm
import uk.gov.hmrc.playcrosscompilation.PlayVersion._
import uk.gov.hmrc.{SbtArtifactory, SbtAutoBuildPlugin}

val libName: String = "platops-example-library"

lazy val root = Project(libName, file("."))
  .enablePlugins(SbtAutoBuildPlugin, SbtGitVersioning, SbtArtifactory)
  .settings(
    makePublicallyAvailableOnBintray := true,
    majorVersion              := 0,
    scalaVersion              := "2.11.11",
    targetJvm                 := "jvm-1.8",
    libraryDependencies       ++= compileDependencies ++ testDependencies,
    resolvers := Seq(
      Resolver.bintrayRepo("hmrc", "releases"),
      Resolver.typesafeRepo("releases")
    ),
    playCrossCompilationSettings
  )

val compileDependencies = DependenciesSeq(
  "com.typesafe.play" %% "play-json" % "2.5.12" crossPlay Play25,
  "com.typesafe.play" %% "play-json" % "2.6.8" crossPlay Play26
)

val testDependencies = Seq(
  "org.scalatest"  %% "scalatest"  % "3.0.3" % Test,
  "org.mockito"    % "mockito-all" % "1.9.5" % Test,
  "org.pegdown"    %  "pegdown"    % "1.6.0" % Test
)
