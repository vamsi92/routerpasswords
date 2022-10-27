# routerpasswords
**How to setup this project.**
==========================================
1. Clone this project to your local drive
2. open either eclipse or intellij ide
3. if eclipse then select File-> Import-> Maven -> Existing Maven Projects and click on next
4. Browse the project location. The project folder name is **RouterProject** and click finish
5. Wait for dependencies to get build.
6. Make sure to update the chrome browser to latest one. Also download chrome driver according to the chrome browser version and replace chromedriver in resources folder with newly downloaded.
7. Now, Expand src/test/java package
8. inside we will have com.routerpasswords.tests package.
9. When expand it will have test files
10. right click on FindAndStorePasswordAllManufacturerTest.java class and run as -> Junit test
11. Now the test will run and after test runs, the output.xls file will be created in resources folder.
12. We also have TestRunner class inside com.routerpasswords.runner package which does the same test execution.
