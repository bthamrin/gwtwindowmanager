/*
 * Copyright (c) 2006 gwtwindowmanager.org (http://www.gwtwindowmanager.org)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.gwm.client;

import org.gwm.client.impl.DefaultFramesManager;

/**
 * Provides an implementation of the FramesManager. Typically the first class,
 * you have to instanciate.
 * 
 * 
 * @author luciano broussal
 * 
 * Type FramesManagerFactory, created on 27 nov. 06 at 18:11:31
 * 
 */
public class FramesManagerFactory {

    /**
     * Generates a new FramesManager for your application.
     * 
     * @return a FramesManager instance.
     */
    public FramesManager createFramesManager() {
        return new DefaultFramesManager();
    }
}
