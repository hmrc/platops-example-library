import sbt._

object LibDependencies {
  val play29 = Seq(
    "com.typesafe.play" %% s"play" % "2.9.0"
  )

  val play30 = Seq(
    "org.playframework" %% s"play" % "3.0.0"
  )

  val test = Seq(
    "org.scalatest"        %% "scalatest"    % "3.2.17" % Test,
    "com.vladsch.flexmark" %  "flexmark-all" % "0.64.8" % Test
  )
}
