import sbt._

object LibDependencies {
  val play30 = Seq(
    "org.playframework" %% "play" % "3.0.9"
  )

  val test = Seq(
    "org.scalatest"        %% "scalatest"    % "3.2.17" % Test,
    "com.vladsch.flexmark" %  "flexmark-all" % "0.64.8" % Test
  )
}
