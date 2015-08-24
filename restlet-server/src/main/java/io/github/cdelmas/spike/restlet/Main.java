/*
   Copyright 2015 Cyril Delmas

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package io.github.cdelmas.spike.restlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.github.cdelmas.spike.restlet.car.CarModule;
import io.github.cdelmas.spike.restlet.hello.HelloModule;
import io.github.cdelmas.spike.restlet.infrastructure.di.RestletInfraModule;
import org.restlet.ext.guice.SelfInjectingServerResourceModule;

public class Main {

    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(new SelfInjectingServerResourceModule(),
                new RestletInfraModule(),
                new CarModule(),
                new HelloModule());
        RestComponent component = injector.getInstance(RestComponent.class);
        component.start();
    }
}