package org.example;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {


    Main main;
    @Before
    public void loadMainClass(){
        main = new Main();
    }


    @Test
    public void ZeroReturnedOnBadBrackets(){
        Assert.assertEquals(main.BracketMatcher("(coder)(byte))"  ),"0");
    }

    @Test
    public void OneReturnedOnOkBrackets(){
        Assert.assertEquals(main.BracketMatcher("(c(oder)) b(yte)"  ),"1");
    }
    @Test
    public void OneReturnedOnNonBrackets(){
        Assert.assertEquals(main.BracketMatcher("coder byte"  ),"1");
    }
}
