package com.zzh.client.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private long id;
    private User user;
    private Admin admin;
    private Menu menu;
    private Date date;
    private int state;
}
