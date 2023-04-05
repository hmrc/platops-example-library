val scala2_12 = "2.12.17"
val scala2_13 = "2.13.10"

lazy val library = (project in file("."))
  .settings(
    commonSettings,
    publish / skip := true,
  )
  .aggregate(
    play28
  )

lazy val play28 = Project("platops-example-library-play-28", file("play-28"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq("com.typesafe.play" %% "play-json" % "2.9.2") ++ testDependencies,
    sharedSources
  )

val testDependencies = Seq(
  "org.scalatest"        %% "scalatest"    % "3.2.7"   % Test,
  "com.vladsch.flexmark" %  "flexmark-all" % "0.35.10" % Test
)

lazy val commonSettings = Seq(
  majorVersion       := 0,
  scalaVersion       := scala2_12,
  crossScalaVersions := Seq(scala2_12, scala2_13),
  isPublicArtefact   := true
)

def sharedSources = Seq(
  Compile / unmanagedSourceDirectories   += baseDirectory.value / "../shared/src/main/scala",
  Compile / unmanagedResourceDirectories += baseDirectory.value / "../shared/src/main/resources",
  Test    / unmanagedSourceDirectories   += baseDirectory.value / "../shared/src/test/scala",
  Test    / unmanagedResourceDirectories += baseDirectory.value / "../shared/src/test/resources"
)
