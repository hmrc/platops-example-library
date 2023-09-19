import sbt._

object LibDependencies {
  val play28 = Seq(
    "com.typesafe.play" %% "play" % "2.8.20"
  )

  val play29 = Seq(
    "com.typesafe.play" %% s"play" % "2.9.0-M7"
  )

  val test = Seq(
    "org.scalatest"        %% "scalatest"    % "3.2.15" % Test,
    "com.vladsch.flexmark" %  "flexmark-all" % "0.62.2" % Test
  )
}
