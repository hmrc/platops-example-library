val scala2_13 = "2.13.12"
val scala3    = "3.3.3"

ThisBuild / scalaVersion       := scala2_13
ThisBuild / majorVersion       := 1
ThisBuild / isPublicArtefact   := true

lazy val library = (project in file("."))
  .settings(publish / skip := true)
  .aggregate(
    play29,
    play30
  )

lazy val play29 = Project("platops-example-library-play-29", file("play-29"))
  .settings(
    libraryDependencies ++= LibDependencies.play29 ++ LibDependencies.test,
    sharedSources
  )

lazy val play30 = Project("platops-example-library-play-30", file("play-30"))
  .settings(
    crossScalaVersions := Seq(scala2_13, scala3),
    libraryDependencies ++= LibDependencies.play30 ++ LibDependencies.test,
    sharedSources
  )

def sharedSources = Seq(
  Compile / unmanagedSourceDirectories   += baseDirectory.value / "../shared/src/main/scala",
  Compile / unmanagedResourceDirectories += baseDirectory.value / "../shared/src/main/resources",
  Test    / unmanagedSourceDirectories   += baseDirectory.value / "../shared/src/test/scala",
  Test    / unmanagedResourceDirectories += baseDirectory.value / "../shared/src/test/resources"
)
