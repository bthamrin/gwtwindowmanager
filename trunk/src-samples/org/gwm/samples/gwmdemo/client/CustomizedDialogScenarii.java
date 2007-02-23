/*
 * Copyright (c) 2006-2007 Luciano Broussal, Johan Vos, Andy Scholz, Marcelo Emanoel  (http://www.gwtwindowmanager.org)
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

package org.gwm.samples.gwmdemo.client;

import org.gwm.client.GDialog;
import org.gwm.client.event.GDialogChoiceListener;
import org.gwm.client.impl.DefaultGDialog;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;

public class CustomizedDialogScenarii extends AbstractScenarii {

    public CustomizedDialogScenarii() {        super();
    }

    public void runScenarii() {
        DefaultGDialog gdialog = new DefaultGDialog("Customized DefaultGDialog");
        HTML content = new HTML("This a customized GDialog content");
        gdialog.setMessage(content);
        gdialog.setMessageType(GDialog.PLAIN_MESSAGE);
        gdialog.setOptionType(GDialog.OK_OPTION_TYPE);
        gdialog.show();
    }

    protected Hyperlink createLink() {
        Hyperlink desktopDemoLink = new Hyperlink("Customized DefaultGDialog",
                "customized_dialog");
        return desktopDemoLink;
    }

}
