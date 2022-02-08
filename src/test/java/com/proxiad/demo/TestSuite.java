package com.proxiad.demo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({GamePlayTest.class, FinishedGameTest.class})
public class TestSuite {

}
