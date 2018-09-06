
import sbt.Keys.scalaVersion
import sbt.PlayCrossCompilation
import uk.gov.hmrc.DefaultBuildSettings.targetJvm
import uk.gov.hmrc.{SbtArtifactory, SbtAutoBuildPlugin}
import sbt.PlayCrossCompilation._

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
    PlayCrossCompilation()
  )

val compileDependencies = {

  val play25Dependencies = Seq(
    "com.typesafe.play" %% "play-json"            % "2.5.12"
  )

  val play26Dependencies = Seq(
    "com.typesafe.play" %% "play-json"            % "2.6.8"
  )

  Seq(
    "org.scalatest" %% "scalatest" % "3.0.5",
    "org.pegdown"   % "pegdown"    % "1.6.0"
  ) ++ (
    if (playVersion == Play25) play25Dependencies else play26Dependencies
    )

}


val testDependencies = Seq(
  "org.scalatest"          %% "scalatest"          % "3.0.3"             % "test",
  "org.mockito"            % "mockito-all"         % "1.9.5"             % "test",
  "org.pegdown"            %  "pegdown"            % "1.6.0"              % "test"
)
