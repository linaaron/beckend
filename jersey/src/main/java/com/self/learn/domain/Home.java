package com.self.learn.domain;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by aaronl on 10/14/2015.
 */
@XmlRootElement //表示可以被转换为xml或json格式
public class Home implements java.io.Serializable {

    @FormParam("roomno")
    private int roomNo;

    @FormParam("address")
    private String address;

    private String longtime;

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongtime() {
        return longtime;
    }

    public void setLongtime(String longtime) {
        this.longtime = longtime;
    }

    public String toString() {
        return "roomNo:" + roomNo + "  address:" + address + "  longtime:" + longtime;
    }
}
