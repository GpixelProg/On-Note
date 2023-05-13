package gpixel.prog.note.data.database

import gpixel.prog.note.data.db_model.UserModel
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import org.mongodb.kbson.ObjectId

object UserDB {
    private val config = RealmConfiguration.create(schema = setOf(UserModel::class))
    private val realm = Realm.open(config)

    fun getUser(email: String, passwordHash: String) : ObjectId? {
        val user = realm.query<UserModel>("email = $email and pwd = $passwordHash").find().firstOrNull()
        return user?.id
    }

    fun addUser(email: String, passwordHash: String) : ObjectId {
        val user = UserModel().apply {
            this.email = email
            this.pwd = passwordHash
        }
        realm.writeBlocking {
            copyToRealm(user)
        }
        return user.id
    }
}