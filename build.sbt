/*
 * Copyright © 2017 Lightbend, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Lightbend, Inc.
 */

lazy val examples = project
  .in(file("."))
  .aggregate(mdc, timed)

lazy val mdc = project
  .in(file("example/mdc"))
  .enablePlugins(Cinnamon)
  .settings(
    scalaVersion := "2.11.8",
    // for MDC progation, only need to add this dependency:
    libraryDependencies += Cinnamon.library.cinnamonSlf4jMdc,
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.8",
    cinnamon in run := true
  )

lazy val timed = project
  .in(file("example/timed"))
  .enablePlugins(Cinnamon)
  .settings(
    scalaVersion := "2.11.8",
    // instrumentation SPI for Scala Futures (normally internal only, provided by Cinnamon agent)
    libraryDependencies += Cinnamon.library.cinnamonScalaFutureSPI % "provided",
    cinnamon in run := true
  )
