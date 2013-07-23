/** 
 * Copyright (c) 2009-2011, The HATS Consortium. All rights reserved. 
 * This file is licensed under the terms of the Modified BSD License.
 */
package abs.backend.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import abs.backend.BackendTestDriver;

@RunWith(Parameterized.class)
public class ObjectTests extends SemanticTests {

    public ObjectTests(BackendTestDriver d) {
        super(d);
    }

    @Test
    public void nullCompare() {
        assertEvalTrue("interface I {} { Bool testresult = False; I i = null; if (i == null) testresult = True; }");
    }

    @Test
    public void refEq() {
        assertEvalTrue("interface I {} class C implements I {} { I i1 = new C(); Bool testresult = i1 == i1; }");
    }

    @Test
    public void refEq2() {
        assertEvalTrue("interface I {} class C implements I {} { I i1 = new C(); I i2 = new C(); Bool testresult = ~(i1 == i2); }");
    }
    
    @Test
    public void refGt() {
        assertEvalTrue("interface I {} class C implements I {} { I i1 = new C(); I i2 = new C(); Bool testresult = i1 > i2 || i2 > i1; }");
    }
    
    @Test
    public void refLt() {
        assertEvalTrue("interface I {} class C implements I {} { I i1 = new C(); I i2 = new C(); Bool testresult = i1 < i2 || i2 < i1; }");
    }
    
    @Test
    public void refGtEq() {
        assertEvalTrue("interface I {} class C implements I {} { I i1 = new C(); I i2 = new C(); Bool testresult = i1 >= i2 || i1 < i2; }");
    }

    @Test
    public void refLtEq() {
        assertEvalTrue("interface I {} class C implements I {} { I i1 = new C(); I i2 = new C(); Bool testresult = i1 <= i2 || i1 > i2; }");
    }

    @Test
    public void futLt() {
        assertEvalTrue("interface I {Int m(Int i); Unit doit();}"
                + "class C implements I {Bool flag = False; Int m (Int i) {await flag; return i;} Unit doit() {flag = True;}}"
                + "{I i1 = new cog C(); I i2 = new cog C(); Bool reforder = i1 < i2; Int inti1 = if reforder then 1 else 2; Int inti2 = if reforder then 2 else 1; Fut<Int> fi1 = i1!m(inti1); Fut<Int> fi2 = i2!m(inti2); Bool futorder = fi1 < fi2; i1!doit(); i2!doit(); fi1.get; fi2.get; Bool testresult = if futorder then fi1 < fi2 else fi2 < fi1;}");
    }

    @Test
    public void classDecl() {
        assertEvalTrue("class C { } { Bool testresult = True; }");
    }

    private static String EMPTY_CLASS_C = "interface I { } class C implements I { }";

    @Test
    public void intfClassDecl() {
        assertEvalTrue(EMPTY_CLASS_C + "{ Bool testresult = True; I i; }");
    }

    @Test
    public void newExp() {
        assertEvalTrue(EMPTY_CLASS_C + " { Bool testresult = True; I i = new C();}");
    }

    private static String CLASS_WITH_METHOD = "interface I { Bool m(); } class C implements I { Bool m() { return True; } }";

    @Test
    public void methodCall() {
        assertEvalTrue(CLASS_WITH_METHOD + " { Bool testresult = True; I i = new C(); testresult = i.m();}");
    }

    private static String INTERFACE_I = "interface I { Bool m(); }";
    private static String CLASS_WITH_FIELD = INTERFACE_I
            + " class C(Bool f) implements I { Bool m() { return this.f; } }";

    private static String CALL_M = " { Bool testresult = True; I i = new C(True); testresult = i.m();}";

    @Test
    public void fieldAccess() {
        assertEvalTrue(CLASS_WITH_FIELD + CALL_M);
    }

    private static String CLASS_WITH_ASSIGN = INTERFACE_I
            + "class C(Bool f) implements I { Bool x = False; Bool m() { this.x = this.f; return this.x; } }";

    @Test
    public void fieldAssign() {
        assertEvalTrue(CLASS_WITH_ASSIGN + CALL_M);
    }

    private static String CLASS_WITH_INITBLOCK = INTERFACE_I
            + "class C(Bool f) implements I { Bool x = False; { x = True; } Bool m() { return this.x; } }";

    @Test
    public void initBlock() {
        assertEvalTrue(CLASS_WITH_INITBLOCK + CALL_M);
    }

    @Test
    public void classParamReadInFieldAssign() {
        assertEvalTrue(INTERFACE_I + " class C(Bool f) implements I { Bool x = f; Bool m() { return this.x; } }"
                + CALL_M);
    }

    @Test
    public void classMethodShadowsField1() {
        assertEvalTrue("interface I { Bool m(Bool f); } class C(Bool f) implements I { Bool m(Bool f) { return f; } }"
                + "{ Bool testresult = False; I i = new C(False); testresult = i.m(True);}");
    }

    @Test
    public void classMethodShadowsField2() {
        assertEvalTrue("interface I { Bool m(Bool f); } class C(Bool f) implements I { Bool m(Bool f) { return this.f; } }"
                + "{ Bool testresult = False; I i = new C(True); testresult = i.m(False);}");
    }
}
