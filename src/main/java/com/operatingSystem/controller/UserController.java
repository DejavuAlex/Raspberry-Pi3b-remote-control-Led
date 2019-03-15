package com.operatingSystem.controller;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;


@Controller


public class UserController {


    static class G {
        private static int l = 500;

        public static int getL() {
            return l;
        }

        public static void setL(int l) {
            G.l = l;
        }
    }

    @RequestMapping(value = "user", method = {RequestMethod.GET, RequestMethod.POST})
    public void user() {


    }
    @RequestMapping(value = "xxx", method = {RequestMethod.GET, RequestMethod.POST})
    public void xxx( HttpServletRequest request) {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.HIGH);
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.HIGH);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, PinState.HIGH);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.HIGH);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.HIGH);
        final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.HIGH);
        final GpioPinPwmOutput pinR = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "MyLED", 100);
        final GpioPinPwmOutput pinB = gpio.provisionPwmOutputPin(RaspiPin.GPIO_23, "MyLED", 100);
        final GpioPinPwmOutput pinG = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01, "MyLED", 100);

        if(pin0.isLow()){

            request.getSession().setAttribute("name",1);
        }
        if(pin1.isLow()){

            request.getSession().setAttribute("name",2);
        }
        if(pin2.isLow()){

            request.getSession().setAttribute("name",3);
        }
        if(pin3.isLow()){

            request.getSession().setAttribute("name",4);
        }
        if(pin4.isLow()){

            request.getSession().setAttribute("name",5);
        }
        if(pin5.isLow()){

            request.getSession().setAttribute("name",6);
        }
        if(pin6.isLow()){

            request.getSession().setAttribute("name",7);
        }
        if(pin7.isLow()){

            request.getSession().setAttribute("name",8);
        }

        gpio.unprovisionPin(pin0);
        gpio.unprovisionPin(pin1);
        gpio.unprovisionPin(pin2);
        gpio.unprovisionPin(pin3);
        gpio.unprovisionPin(pin4);
        gpio.unprovisionPin(pin5);
        gpio.unprovisionPin(pin6);
        gpio.unprovisionPin(pin7);
        gpio.unprovisionPin(pinR);
        gpio.unprovisionPin(pinG);
        gpio.unprovisionPin(pinB);

    }
    @RequestMapping(value = "brighter", method = {RequestMethod.GET, RequestMethod.POST})
    public void brighter() {

        G.setL(G.getL() + 200);
        if (G.getL() >= 1000) {
            G.setL(0);
        }
    }

    @RequestMapping(value = "dimmer", method = {RequestMethod.GET, RequestMethod.POST})
    public void dimmer() {
        G.setL(G.getL() - 200);
        if (G.getL() <= 0) {
            G.setL(1000);
        }
    }

    @RequestMapping(value = "test", method = {RequestMethod.GET, RequestMethod.POST})
    public void test(@RequestParam("identity") String inputStr, @RequestParam("doc-select-1") String led, HttpServletRequest request) {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.HIGH);
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.HIGH);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, PinState.HIGH);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.HIGH);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.HIGH);
        final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.HIGH);
        final GpioPinPwmOutput pinR = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "MyLED", 100);
        final GpioPinPwmOutput pinB = gpio.provisionPwmOutputPin(RaspiPin.GPIO_23, "MyLED", 100);
        final GpioPinPwmOutput pinG = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01, "MyLED", 100);
        pin0.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin1.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin2.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin3.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin4.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin5.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin6.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin7.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pinR.setPwm(0);
        pinG.setPwm(0);
        pinB.setPwm(0);
        if (led.equals("LED1")) {
            request.getSession().setAttribute("name","Led1");
            pin0.low();
            if (inputStr.equals("Red")) {
                pinR.setPwm(G.getL());
                pinG.setPwm(0);
                pinB.setPwm(0);
            }
            if (inputStr.equals("Green")) {
                pinR.setPwm(0);
                pinG.setPwm(G.getL());
                pinB.setPwm(0);
            }
            if (inputStr.equals("Blue")) {
                pinR.setPwm(0);
                pinG.setPwm(0);
                pinB.setPwm(G.getL());

            }
        }
        if (led.equals("LED2")) {
            request.getSession().setAttribute("name","Led2");
            pin1.low();
            if (inputStr.equals("Red")) {
                pinR.setPwm(G.getL());
                pinG.setPwm(0);
                pinB.setPwm(0);

            }
            if (inputStr.equals("Green")) {
                pinR.setPwm(0);
                pinG.setPwm(G.getL());
                pinB.setPwm(0);
            }
            if (inputStr.equals("Blue")) {
                pinR.setPwm(0);
                pinG.setPwm(0);
                pinB.setPwm(G.getL());

            }
        }
        if (led.equals("LED3")) {
            request.getSession().setAttribute("name","Led3");
            pin2.low();
            if (inputStr.equals("Red")) {
                pinR.setPwm(G.getL());
                pinG.setPwm(0);
                pinB.setPwm(0);

            }
            if (inputStr.equals("Green")) {
                pinR.setPwm(0);
                pinG.setPwm(G.getL());
                pinB.setPwm(0);
            }
            if (inputStr.equals("Blue")) {
                pinR.setPwm(0);
                pinG.setPwm(0);
                pinB.setPwm(G.getL());

            }
        }
        if (led.equals("LED4")) {
            request.getSession().setAttribute("name","Led4");
            pin3.low();
            if (inputStr.equals("Red")) {
                pinR.setPwm(G.getL());
                pinG.setPwm(0);
                pinB.setPwm(0);

            }
            if (inputStr.equals("Green")) {
                pinR.setPwm(0);
                pinG.setPwm(G.getL());
                pinB.setPwm(0);
            }
            if (inputStr.equals("Blue")) {
                pinR.setPwm(0);
                pinG.setPwm(0);
                pinB.setPwm(G.getL());

            }
        }
        if (led.equals("LED5")) {
            request.getSession().setAttribute("name","Led5");
            pin4.low();
            if (inputStr.equals("Red")) {
                pinR.setPwm(G.getL());
                pinG.setPwm(0);
                pinB.setPwm(0);

            }
            if (inputStr.equals("Green")) {
                pinR.setPwm(0);
                pinG.setPwm(G.getL());
                pinB.setPwm(0);
            }
            if (inputStr.equals("Blue")) {
                pinR.setPwm(0);
                pinG.setPwm(0);
                pinB.setPwm(G.getL());

            }
        }
        if (led.equals("LED6")) {
            request.getSession().setAttribute("name","Led6");
            pin5.low();
            if (inputStr.equals("Red")) {
                pinR.setPwm(G.getL());
                pinG.setPwm(0);
                pinB.setPwm(0);

            }
            if (inputStr.equals("Green")) {
                pinR.setPwm(0);
                pinG.setPwm(G.getL());
                pinB.setPwm(0);
            }
            if (inputStr.equals("Blue")) {
                pinR.setPwm(0);
                pinG.setPwm(0);
                pinB.setPwm(G.getL());

            }
        }
        if (led.equals("LED7")) {
            request.getSession().setAttribute("name","Led7");
            pin6.low();
            if (inputStr.equals("Red")) {
                pinR.setPwm(G.getL());
                pinG.setPwm(0);
                pinB.setPwm(0);

            }
            if (inputStr.equals("Green")) {
                pinR.setPwm(0);
                pinG.setPwm(G.getL());
                pinB.setPwm(0);
            }
            if (inputStr.equals("Blue")) {
                pinR.setPwm(0);
                pinG.setPwm(0);
                pinB.setPwm(G.getL());

            }
        }
        if (led.equals("LED8")) {
            request.getSession().setAttribute("name","led8");
            pin7.low();
            if (inputStr.equals("Red")) {
                pinR.setPwm(G.getL());
                pinG.setPwm(0);
                pinB.setPwm(0);

            }
            if (inputStr.equals("Green")) {
                pinR.setPwm(0);
                pinG.setPwm(G.getL());
                pinB.setPwm(0);
            }
            if (inputStr.equals("Blue")) {
                pinR.setPwm(0);
                pinG.setPwm(0);
                pinB.setPwm(G.getL());

            }
        }
        if (led.equals("All")) {
            pin0.low();
            pin1.low();
            pin2.low();
            pin3.low();
            pin4.low();
            pin5.low();
            pin6.low();
            pin7.low();
            if (inputStr.equals("Red")) {
                pinG.setPwm(0);
                pinB.setPwm(0);
                pinR.setPwm(G.getL());

            }
            if (inputStr.equals("Green")) {
                pinR.setPwm(0);
                pinG.setPwm(G.getL());
                pinB.setPwm(0);
            }
            if (inputStr.equals("Blue")) {
                pinR.setPwm(0);
                pinG.setPwm(0);
                pinB.setPwm(G.getL());
            }
        }

        gpio.unprovisionPin(pin0);
        gpio.unprovisionPin(pin1);
        gpio.unprovisionPin(pin2);
        gpio.unprovisionPin(pin3);
        gpio.unprovisionPin(pin4);
        gpio.unprovisionPin(pin5);
        gpio.unprovisionPin(pin6);
        gpio.unprovisionPin(pin7);
        gpio.unprovisionPin(pinR);
        gpio.unprovisionPin(pinG);
        gpio.unprovisionPin(pinB);
    }


    @RequestMapping(value = "test3", method = {RequestMethod.GET, RequestMethod.POST})
    public void test2() throws Exception {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.HIGH);
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.HIGH);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, PinState.HIGH);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.HIGH);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.HIGH);
        final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.HIGH);
        final GpioPinPwmOutput pinR = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "MyLED", 100);
        final GpioPinPwmOutput pinB = gpio.provisionPwmOutputPin(RaspiPin.GPIO_23, "MyLED", 100);
        final GpioPinPwmOutput pinG = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01, "MyLED", 100);
        pin0.low();
        pin1.low();
        pin2.low();
        pin3.low();
        pin4.low();
        pin5.low();
        pin6.low();
        pin7.low();
        pinG.setPwm(0);
        pinB.setPwm(0);
        pinR.setPwm(0);
        for (int i = 0; i <= 1000; i = i + 250) {
            pinR.setPwm(i);
            Thread.sleep(500);
        }
        pinR.setPwm(0);
        for (int i = 1000; i >= 0; i = i - 250) {
            pinB.setPwm(i);
            Thread.sleep(500);
        }
        pinB.setPwm(0);
        for (int i = 0; i <= 1000; i = i + 250) {
            pinR.setPwm(i);
            Thread.sleep(500);
        }
        pinR.setPwm(0);
        for (int i = 1000; i >= 0; i = i - 250) {
            pinB.setPwm(i);
            Thread.sleep(500);
        }
        pinB.setPwm(0);
        for (int i = 1000; i >= 0; i = i - 250) {
            pinR.setPwm(i);pinG.setPwm(0);
            pinB.setPwm(i);

            Thread.sleep(500);
        }
        gpio.unprovisionPin(pin0);
        gpio.unprovisionPin(pin1);
        gpio.unprovisionPin(pin2);
        gpio.unprovisionPin(pin3);
        gpio.unprovisionPin(pin4);
        gpio.unprovisionPin(pin5);
        gpio.unprovisionPin(pin6);
        gpio.unprovisionPin(pin7);
        gpio.unprovisionPin(pinR);
        gpio.unprovisionPin(pinG);
        gpio.unprovisionPin(pinB);
    }

    @RequestMapping(value = "test4", method = {RequestMethod.GET, RequestMethod.POST})
    public void test4() throws Exception {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.HIGH);
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.HIGH);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, PinState.HIGH);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.HIGH);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.HIGH);
        final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.HIGH);
        final GpioPinPwmOutput pinR = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "MyLED", 100);
        final GpioPinPwmOutput pinB = gpio.provisionPwmOutputPin(RaspiPin.GPIO_23, "MyLED", 100);
        final GpioPinPwmOutput pinG = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01, "MyLED", 100);
        pin0.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin1.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin2.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin3.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin4.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin5.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin6.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin7.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pinR.setPwm(0);
        pinG.setPwm(0);
        pinB.setPwm(0);
        gpio.unprovisionPin(pin0);
        gpio.unprovisionPin(pin1);
        gpio.unprovisionPin(pin2);
        gpio.unprovisionPin(pin3);
        gpio.unprovisionPin(pin4);
        gpio.unprovisionPin(pin5);
        gpio.unprovisionPin(pin6);
        gpio.unprovisionPin(pin7);
        gpio.unprovisionPin(pinR);
        gpio.unprovisionPin(pinG);
        gpio.unprovisionPin(pinB);
    }

    @RequestMapping(value = "test2", method = {RequestMethod.GET, RequestMethod.POST})
    public void test3() throws Exception {

        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.HIGH);
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.HIGH);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, PinState.HIGH);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.HIGH);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.HIGH);
        final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.HIGH);
        final GpioPinPwmOutput pinR = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "MyLED", 100);
        final GpioPinPwmOutput pinB = gpio.provisionPwmOutputPin(RaspiPin.GPIO_23, "MyLED", 100);
        final GpioPinPwmOutput pinG = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01, "MyLED", 100);
        pin0.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin1.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin2.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin3.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin4.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin5.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin6.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin7.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pinR.setPwm(0);
        pinG.setPwm(0);
        pinB.setPwm(0);

        for (int i = 200; i <= 1000; i = i + 100) {
            pin0.low();
            pinR.setPwm(i);
            Thread.sleep(100);
            pinR.setPwm(0);
            pin0.toggle();
            pin1.low();
            pinB.setPwm(i);
            Thread.sleep(100);
            pinB.setPwm(0);
            pin1.toggle();
            pin2.low();
            pinR.setPwm(i);
            pinB.setPwm(i);
            Thread.sleep(100);
            pinB.setPwm(0);
            pinR.setPwm(0);
            pin2.toggle();
            pin3.low();
            pinR.setPwm(i);
            Thread.sleep(100);
            pinR.setPwm(0);
            pin3.toggle();
            pin4.low();
            pinB.setPwm(i);
            Thread.sleep(100);
            pinB.setPwm(0);
            pin4.toggle();
            pin5.low();
            pinB.setPwm(i);
            pinR.setPwm(i);
            Thread.sleep(100);
            pinB.setPwm(0);
            pinR.setPwm(0);
            pin5.toggle();
            pin6.low();
            pinR.setPwm(i);
            Thread.sleep(100);
            pinR.setPwm(0);
            pin6.toggle();
            pin7.low();
            pinB.setPwm(i);
            Thread.sleep(100);
            pinB.setPwm(0);
            pin7.toggle();
        }
        gpio.unprovisionPin(pin0);
        gpio.unprovisionPin(pin1);
        gpio.unprovisionPin(pin2);
        gpio.unprovisionPin(pin3);
        gpio.unprovisionPin(pin4);
        gpio.unprovisionPin(pin5);
        gpio.unprovisionPin(pin6);
        gpio.unprovisionPin(pin7);
        gpio.unprovisionPin(pinR);
        gpio.unprovisionPin(pinG);
        gpio.unprovisionPin(pinB);
    }

    @RequestMapping(value = "test5", method = {RequestMethod.GET, RequestMethod.POST})
    public void test5() throws Exception {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.HIGH);
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.HIGH);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, PinState.HIGH);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.HIGH);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.HIGH);
        final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.HIGH);
        final GpioPinPwmOutput pinR = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "MyLED", 100);
        final GpioPinPwmOutput pinB = gpio.provisionPwmOutputPin(RaspiPin.GPIO_23, "MyLED", 100);
        final GpioPinPwmOutput pinG = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01, "MyLED", 100);
        pin0.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin1.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin2.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin3.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin4.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin5.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin6.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pin7.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pinR.setPwm(0);
        pinG.setPwm(0);
        pinB.setPwm(0);

        pin0.low();pin7.low();
        pinR.setPwm(1000);
        Thread.sleep(500);
        pin1.low();pin6.low();
        pinB.setPwm(1000);
        Thread.sleep(500);
        pin2.low();pin5.low();
        pinR.setPwm(1000);
        Thread.sleep(500);
        pin3.low();pin4.low();
        pinB.setPwm(1000);
        Thread.sleep(500);
        for(int i=0;i<=7;i++)
        {
            pin0.toggle();pin7.toggle();pin2.toggle();pin5.toggle();
            Thread.sleep(200);
            pin1.toggle();pin6.toggle();pin3.toggle();pin4.toggle();
            Thread.sleep(200);
        }
        pin0.toggle();pin7.toggle();
        Thread.sleep(500);
        pin1.toggle();pin6.toggle();
        Thread.sleep(500);
        pin2.toggle();pin5.toggle();
        Thread.sleep(500);
        pin3.toggle();pin4.toggle();
        Thread.sleep(500);
        pinR.setPwm(0);
        pinG.setPwm(0);
        pinB.setPwm(0);
        gpio.unprovisionPin(pin0);
        gpio.unprovisionPin(pin1);
        gpio.unprovisionPin(pin2);
        gpio.unprovisionPin(pin3);
        gpio.unprovisionPin(pin4);
        gpio.unprovisionPin(pin5);
        gpio.unprovisionPin(pin6);
        gpio.unprovisionPin(pin7);
        gpio.unprovisionPin(pinR);
        gpio.unprovisionPin(pinG);
        gpio.unprovisionPin(pinB);
    }




}

