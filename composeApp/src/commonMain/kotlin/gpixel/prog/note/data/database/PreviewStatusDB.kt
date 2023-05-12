package gpixel.prog.note.data.database

import gpixel.prog.note.data.db_model.PreviewStatusModel
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object PreviewStatusDB {
    val config = RealmConfiguration.create(schema = setOf(PreviewStatusModel::class))
    val realm = Realm.open(config)
}