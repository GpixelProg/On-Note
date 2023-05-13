package gpixel.prog.note.domain

import org.mongodb.kbson.ObjectId

val auth: Auth = Auth()
class Auth {
    var userId: ObjectId? = null

    init {

    }

    fun isAuth(): Boolean {
        return userId != null
    }
}