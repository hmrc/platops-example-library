import PlayCrossCompilation._

lazy val root = Project("platops-example-library", file("."))
  .settings(
    isPublicArtefact          := true,
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
