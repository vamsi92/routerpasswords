package com.routerpasswords.runner;

import com.routerpasswords.tests.FindAndStorePasswordAllManufacturerTest;
import org.junit.runner.JUnitCore;

public class TestRunner {
    public static void main(String[] args) {
        JUnitCore.runClasses(FindAndStorePasswordAllManufacturerTest.class);
    }
}
