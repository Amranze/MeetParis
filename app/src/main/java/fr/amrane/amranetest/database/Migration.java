package fr.amrane.amranetest.database;

import java.util.List;

import fr.amrane.amranetest.application.user.model.User;
import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class Migration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        /* Access to the schema */
        RealmSchema schema = realm.getSchema();
        /*************************
         Version 0 :
         MeetInParis
         User user;
         List<Message> messages;
         List<String> pictures;
         List<String> likes;
         ************************/
        if(oldVersion == 0){
            RealmObjectSchema oximeterSchema = schema.get("UserModel");
            oximeterSchema
                    .addField("user", User.class, FieldAttribute.REQUIRED)
                    .addField("message", List.class, FieldAttribute.REQUIRED)
                    .addField("pictures", List.class, FieldAttribute.REQUIRED)
                    .addField("likes", List.class, FieldAttribute.REQUIRED)
                    .transform(new RealmObjectSchema.Function(){
                        @Override
                        public void apply(DynamicRealmObject obj) {
                            obj.set("user", obj.get("user"));
                            obj.set("message", obj.get("message"));
                            obj.set("pictures", obj.get("pictures"));
                            obj.set("likes", obj.get("likes"));
                        }
                    });
            //oldVersion++;
        }
    }
    @Override
    public boolean equals(Object object) {
        return object != null && object instanceof Migration;
    }

    @Override
    public int hashCode() {
        return Migration.class.hashCode();
    }
}
