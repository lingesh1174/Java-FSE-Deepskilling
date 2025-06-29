package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    ArithmeticOperationsTest.class,
    AssertionsTest.class
})
public class AllFilesTests{
}