
# platops-example-library

![](https://img.shields.io/github/v/release/hmrc/platops-example-library)

This is an example minimal library with a support for cross-compilation for Play 2.8 and 2.9.

In this example, we've used `TypedMap` to show how to deal with [breaking changes](https://github.com/playframework/playframework/pull/11672/files) between different library versions.
The gist of it is to create different modules ([play-2.8](./build.sbt#L14) and [play-2.9](./build.sbt#L21)) that contain a different implementation according to their particular versions.
