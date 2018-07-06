
import sbt.Keys.scalaVersion
import uk.gov.hmrc.DefaultBuildSettings.targetJvm
import uk.gov.hmrc.versioning.SbtGitVersioning.majorVersion
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
    )
  )

val compileDependencies = Seq()

val testDependencies = Seq(
  "org.scalatest"          %% "scalatest"          % "3.0.3"             % "test",
  "org.mockito"            % "mockito-all"         % "1.9.5"             % "test",
  "org.pegdown"            %  "pegdown"            % "1.6.0"              % "test"
)
