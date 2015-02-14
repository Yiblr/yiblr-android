package com.petersoboyejo.yiblr;

import com.orm.SugarApp;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class DaybreakApplication extends SugarApp implements Injector {
    private ObjectGraph graph;

    @Override public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.asList(
                new AndroidModule(this),
                new AppModule()
        );
    }

    @Override public void inject(Object object) {
        graph.inject(object);
    }
}
