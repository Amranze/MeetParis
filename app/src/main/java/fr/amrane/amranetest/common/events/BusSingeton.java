package fr.amrane.amranetest.common.events;

import com.squareup.otto.Bus;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public enum BusSingeton {
    INSTANCE;
    private Bus bus;

    public Bus getBus(){
        ensureBusExistence();
        return bus;
    }

    private void ensureBusExistence(){
        if(bus == null){
            bus = new Bus();
        }
    }
}
