package fr.amrane.amranetest.database;

import fr.amrane.amranetest.application.App;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class RealmHandler {
    private Realm realm = Realm.getDefaultInstance();
    public static RealmHandler INSTANCE = new RealmHandler();

    public void configureRealmDataBase(){
        RealmConfiguration config = new RealmConfiguration.Builder(App.getAppContext())
                .name("MeetInParis")
                .schemaVersion(1)
                //.migration(new Migration())
                .deleteRealmIfMigrationNeeded()
                .build();

        realm = Realm.getInstance(config);
    }

    public <T> void insertDataToRealm(final T deviceData) {
    }
    public void executeQuery() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

            }
        });
    }
}
