lazy val library = (project in file("."))
  .settings(
    commonSettings,
    publish / skip := true
  )
  .aggregate(
    play26,
    play27,
    play28
  )

lazy val play26 = Project("platops-example-library-play-26", file("play-26"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq("com.typesafe.play" %% "play-json" % "2.6.8") ++ testDependencies,
    sharedSources
  )

lazy val play27 = Project("platops-example-library-play-27", file("play-27"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq("com.typesafe.play" %% "play-json" % "2.7.4") ++ testDependencies,
    sharedSources
  )

lazy val play28 = Project("platops-example-library-play-28", file("play-28"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq("com.typesafe.play" %% "play-json" % "2.8.1") ++ testDependencies,
    sharedSources
  )

val testDependencies = Seq(
  "org.scalatest"        %% "scalatest"    % "3.2.6"   % Test,
  "com.vladsch.flexmark" %  "flexmark-all" % "0.35.10" % Test
)

lazy val commonSettings = Seq(
  majorVersion     := 0,
  scalaVersion     := "2.12.14",
  isPublicArtefact := true
)

def sharedSources = Seq(
  Compile / unmanagedSourceDirectories   += baseDirectory.value / "../shared/src/main/scala",
  Compile / unmanagedResourceDirectories += baseDirectory.value / "../shared/src/main/resources",
  Test    / unmanagedSourceDirectories   += baseDirectory.value / "../shared/src/test/scala",
  Test    / unmanagedResourceDirectories += baseDirectory.value / "../shared/src/test/resources"
)
