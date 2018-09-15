/**
 * Copyright (c) 2009-2011, The HATS Consortium. All rights reserved. 
 * This file is licensed under the terms of the Modified BSD License.
 */
package abs.backend.java.dynamic;

import static abs.backend.java.dynamic.JavaBackendDynamicTest.*;

import org.junit.Test;
import org.junit.Ignore;
import abs.frontend.typesystem.CaseStudyTypeChecking;

@Ignore
public class CaseStudies extends CaseStudyTypeChecking {

    public CaseStudies(String input) {
        super(input);
    }

    @Test @Override
    public void test() throws Exception {
        super.test();
        assertValidJava(getJavaCodeDynamic(m));
    }

}
