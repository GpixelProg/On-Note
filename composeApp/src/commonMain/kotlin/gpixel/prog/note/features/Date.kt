package gpixel.prog.note.features

import kotlinx.datetime.LocalDate

fun LocalDate.toEpochMilliseconds(): Long {
    return this.toEpochDays().toLong() * 86400000
}