package extension

import model.Config

val config = Config(
    version = Config.Version(
        major = 1,
        minor = 0,
        patch = 0,
        release = Config.Release.Snapshot()
    ),
    group = "com.neoutils.xregex",
)
