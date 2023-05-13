package gpixel.prog.note.domain

import gpixel.prog.note.data.database.UserSessionDB
import org.mongodb.kbson.ObjectId

val auth: Auth = Auth()
class Auth {
    var userId: ObjectId? = null

    init {
        val userSession = UserSessionDB.getUserSession()
        if (userSession != null) {
            userId = userSession._id
        }
    }

    fun isAuth(): Boolean {
        return userId != null
    }

    fun setAuth(userId: ObjectId) {
        this.userId = userId
        UserSessionDB.setUserSession(userId)
    }
}