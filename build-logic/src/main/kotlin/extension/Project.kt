package extension

import model.Config

val config = Config(
    version = Config.Version(
        major = 1,
        minor = 0,
        patch = 0,
        release = Config.Release.Snapshot(number = 2)
    ),
    group = "com.neoutils.xregex",
)
