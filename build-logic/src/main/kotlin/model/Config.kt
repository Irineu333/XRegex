package model

data class Config(
    val version: Version,
    val group: String
) {
    fun module(name: String) = "$group.$name"

    data class Version(
        val major: Int,
        val minor: Int,
        val patch: Int,
        val release: Release
    ) {
        override fun toString(): String {

            if (release != Release.Final) {
                return "$major.$minor.$patch-$release"
            }

            return "$major.$minor.$patch"
        }
    }

    sealed class Release {

        object Final : Release()

        class Candidate(
            private val number: Int = 1
        ) : Release() {
            override fun toString(): String {
                return "rc$number"
            }
        }

        class Snapshot(
            private val number: Int = 1
        ) : Release() {
            override fun toString(): String {
                return "snapshot$number"
            }
        }
    }
}