package gpixel.prog.note.data.database

import gpixel.prog.note.data.db_model.UserSessionModel
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import org.mongodb.kbson.ObjectId

object UserSessionDB {
    private val config = RealmConfiguration.create(schema = setOf(UserSessionModel::class))
    private val realm = Realm.open(config)

    fun getUserSession() : UserSessionModel? {
        return realm.query<UserSessionModel>().find().firstOrNull()
    }

    fun setUserSession(userId: ObjectId) {
        val userSession = UserSessionModel().apply {
            this._id = userId
        }
        realm.writeBlocking {
            copyToRealm(userSession)
        }
    }
}