package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;


@RunWith(PowerMockRunner.class)
@PrepareForTest(DemoUtil.class)  // type we want to mock
public class DemoImplTest {

    @Test
    public void testUseDemoStaticMethod (){
        PowerMockito.mockStatic(DemoUtil.class);//For mocking static functions
        Mockito.when(DemoUtil.demoStaticMethod(1)).thenReturn(1);

        DemoImpl demoImpl= new DemoImpl();

        assertEquals(demoImpl.useDemoStaticMethod(),"function executed successfully");

        /*  on va verifier que la methode DemoUtil.demoStaticMethod(1)
        *   ne sera appeler qu'une seule fois
        * */
        PowerMockito.verifyStatic(Mockito.times(1));
        DemoUtil.demoStaticMethod(1);
    }
}