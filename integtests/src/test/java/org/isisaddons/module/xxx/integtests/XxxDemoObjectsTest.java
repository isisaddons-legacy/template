/*
 *  Copyright 2013~2014 Dan Haywood
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.isisaddons.module.xxx.integtests;

import java.util.List;
import javax.inject.Inject;
import org.isisaddons.module.xxx.fixture.dom.XxxDemoObject;
import org.isisaddons.module.xxx.fixture.dom.XxxDemoObjects;
import org.isisaddons.module.xxx.fixture.scripts.XxxDemoObjectsFixture;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class XxxDemoObjectsTest extends XxxModuleIntegTest {

    @Before
    public void setUpData() throws Exception {
        scenarioExecution().install(new XxxDemoObjectsFixture());
    }

    @Inject
    private XxxDemoObjects xxxDemoObjects;

    @Test
    public void listAll() throws Exception {

        final List<XxxDemoObject> all = wrap(xxxDemoObjects).listAll();
        assertThat(all.size(), is(3));
        
        XxxDemoObject xxxDemoObject = wrap(all.get(0));
        assertThat(xxxDemoObject.getName(), is("Foo"));
    }
    
    @Test
    public void create() throws Exception {

        wrap(xxxDemoObjects).create("Faz");
        
        final List<XxxDemoObject> all = wrap(xxxDemoObjects).listAll();
        assertThat(all.size(), is(4));
    }

}