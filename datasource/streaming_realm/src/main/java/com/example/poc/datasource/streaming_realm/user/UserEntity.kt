package com.example.poc.datasource.streaming_realm.user

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PersistedName
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

@PersistedName("user")
open class UserEntity : RealmObject {

    @PrimaryKey
    @PersistedName("_id")
    var id: ObjectId = ObjectId()

    /**
     *
     */
    var email: String? = null

    var givenName: String? = null

    var familyName: String? = null

    var password: String? = null

}