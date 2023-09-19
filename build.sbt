val scala2_12 = "2.12.17"
val scala2_13 = "2.13.10"

ThisBuild / scalaVersion       := scala2_13
ThisBuild / majorVersion       := 0
ThisBuild / isPublicArtefact   := true

lazy val library = (project in file("."))
  .settings(publish / skip := true)
  .aggregate(
    play28,
    play29,
  )

lazy val play28 = Project("platops-example-library-play-28", file("play-28"))
  .settings(
    crossScalaVersions := Seq(scala2_12, scala2_13),
    libraryDependencies ++= LibDependencies.play28 ++ LibDependencies.test,
    sharedSources
  )

lazy val play29 = Project("platops-example-library-play-29", file("play-29"))
  .settings(
    libraryDependencies ++= LibDependencies.play29 ++ LibDependencies.test,
    sharedSources
  )

def sharedSources = Seq(
  Compile / unmanagedSourceDirectories   += baseDirectory.value / "../shared/src/main/scala",
  Compile / unmanagedResourceDirectories += baseDirectory.value / "../shared/src/main/resources",
  Test    / unmanagedSourceDirectories   += baseDirectory.value / "../shared/src/test/scala",
  Test    / unmanagedResourceDirectories += baseDirectory.value / "../shared/src/test/resources"
)
