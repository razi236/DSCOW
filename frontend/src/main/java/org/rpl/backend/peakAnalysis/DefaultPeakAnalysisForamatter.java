/**
 * Copyright (c) 2009-2011, The HATS Consortium. All rights reserved. 
 * This file is licensed under the terms of the Modified BSD License.
 */
package org.rpl.backend.peakAnalysis;

import java.io.PrintWriter;

public class DefaultPeakAnalysisForamatter implements PeakAnalysisFormatter {

    private final PrintWriter w;
    private static final String INDENT = "  ";
    private StringBuilder indentation = new StringBuilder();
    
    public DefaultPeakAnalysisForamatter(PrintWriter w) {
        this.w = w;
    }

    @Override
    public void beforeOpenBrace() {
    }

    @Override
    public void afterOpenBrace() {
        indentation.append(INDENT);
    }

    @Override
    public void afterStmt() {
        w.print(indentation.toString());
    }

    @Override
    public void beforeCloseBrace() {
        indentation.deleteCharAt(indentation.length()-1);
        indentation.deleteCharAt(indentation.length()-1);
    }

    @Override
    public void afterCloseBrace() {
    }

}
