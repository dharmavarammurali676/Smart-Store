package com.sutrix.demo.core.javapracties;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Window{

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        DateFormat dfor = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Calendar obj = Calendar.getInstance();
        System.out.println(dfor.format(obj.getTime()));
    }

}