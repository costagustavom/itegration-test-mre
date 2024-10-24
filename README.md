#note - all commands should be executed from same terminal

1 - modify the setJava8 and setJava11 scripts to point to your JDKs location 

2 - execute the setJava8 script
    e.g. call scripts/setJava8.bat 

3 - execute gw -version to confirm that you are currently leveraging JVM 1.8.
    e.g.
    C:\dev\itegration-test-mre>gw -version
    
        ------------------------------------------------------------
        Gradle 8.5
        ------------------------------------------------------------
        
        Build time:   2023-11-29 14:08:57 UTC
        Revision:     28aca86a7180baa17117e0e5ba01d8ea9feca598
        
        Kotlin:       1.9.20
        Groovy:       3.0.17
        Ant:          Apache Ant(TM) version 1.10.13 compiled on January 4 2023
        JVM:          1.8.0_202 (Oracle Corporation 25.202-b08)
        OS:           Windows 10 10.0 amd64

4 - execute gw initBundle

5 - execute gw testIntegration
    expected: BUILD SUCCESSFUL in 8m 31s

6 - execute the setJava11 script e.g. call scripts/setJava11.bat

7 - execute gw -version to confirm that you are currently leveraging JVM 11. e.g. C:\dev\itegration-test-mre>gw -version
    
    ------------------------------------------------------------
    Gradle 8.5
    ------------------------------------------------------------
    
    Build time:   2023-11-29 14:08:57 UTC
    Revision:     28aca86a7180baa17117e0e5ba01d8ea9feca598
    
    Kotlin:       1.9.20
    Groovy:       3.0.17
    Ant:          Apache Ant(TM) version 1.10.13 compiled on January 4 2023
    JVM:          11.0.14 (Oracle Corporation 11.0.14+8-LTS-263)
    OS:           Windows 10 10.0 amd64

8 - execute gw initBundle

9 - execute gw testIntegration
    expected: BUILD SUCCESSFUL in 8m 31s
    actual:
    FAILURE: Build failed with an exception.
    
    * What went wrong:
      Execution failed for task ':modules:test:integration-test-mre:testIntegration'.
    > There were failing tests. See the report at: file:///C:/dev/itegration-test-mre/modules/test/integration-test-mre/build/reports/tests/testIntegration/index.html
    
    * Try:
    > Run with --scan to get full insights.
    
    Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.
    
    You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.
    
    For more on this, please refer to https://docs.gradle.org/8.5/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.
    
    BUILD FAILED in 7m 49s

10 - open the report file provided in the stacktrace 
    e.g.
    file:///C:/dev/itegration-test-mre/modules/test/integration-test-mre/build/reports/tests/testIntegration/index.html

11 - verify that it contains the following stacktrace

    java.lang.IllegalArgumentException: Null query
    at aQute.lib.filter.Filter.<init>(Filter.java:266)
    at aQute.bnd.osgi.Verifier.verifyRequirements(Verifier.java:735)
    at aQute.bnd.osgi.Verifier.verify(Verifier.java:531)
    at aQute.bnd.osgi.Builder.doVerify(Builder.java:504)
    at aQute.bnd.osgi.Builder.build(Builder.java:153)
    at com.liferay.arquillian.extension.junit.bridge.client.BndBundleUtil.createBundle(BndBundleUtil.java:66)
    at com.liferay.arquillian.extension.junit.bridge.client.ClientState._installBundle(ClientState.java:243)
    at com.liferay.arquillian.extension.junit.bridge.client.ClientState.open(ClientState.java:78)
    at com.liferay.arquillian.extension.junit.bridge.junit.Arquillian.run(Arquillian.java:120)
    at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.runTestClass(JUnitTestClassExecutor.java:112)
    at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.execute(JUnitTestClassExecutor.java:58)
    at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.execute(JUnitTestClassExecutor.java:40)
    at org.gradle.api.internal.tasks.testing.junit.AbstractJUnitTestClassProcessor.processTestClass(AbstractJUnitTestClassProcessor.java:60)
    at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.processTestClass(SuiteTestClassProcessor.java:52)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:566)
    at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
    at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
    at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:33)
    at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:94)
    at com.sun.proxy.$Proxy2.processTestClass(Unknown Source)
    at org.gradle.api.internal.tasks.testing.worker.TestWorker$2.run(TestWorker.java:176)
    at org.gradle.api.internal.tasks.testing.worker.TestWorker.executeAndMaintainThreadName(TestWorker.java:129)
    at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:100)
    at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:60)
    at org.gradle.process.internal.worker.child.ActionExecutionWorker.execute(ActionExecutionWorker.java:56)
    at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:113)
    at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:65)
    at worker.org.gradle.process.internal.worker.GradleWorkerMain.run(GradleWorkerMain.java:69)
    at worker.org.gradle.process.internal.worker.GradleWorkerMain.main(GradleWorkerMain.java:74)