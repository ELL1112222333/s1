package org.example;

import static org.junit.Assert.assertTrue;

import org.example.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = App.class)
//public class AppTest
//{
//    @Autowired
//    private UserController userController;
//
//
//    /**
//     * Rigorous Test :-)
//     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        for (int i =0;i<10;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    userController.checkController();
//                }
//            }).start();
//        }
//    }
//}

public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
