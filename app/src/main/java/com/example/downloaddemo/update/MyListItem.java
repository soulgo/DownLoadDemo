package com.example.downloaddemo.update;

/**
 * Created by：赖上罗小贱 on 2016/10/31
 * 邮箱：ljq@luojunquan.top
 * 个人博客：www.luojunquan.top
 * CSDN:http://blog.csdn.net/u012990171
 */
public class MyListItem {
    private String data = "";
    private int position = 0;
    private int chooseType = -1;//chooseType 控制listView的选择状态   选中=1  未选中=-1

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getChooseType() {
        return chooseType;
    }

    public void setChooseType(int chooseType) {
        this.chooseType = chooseType;
    }
}
