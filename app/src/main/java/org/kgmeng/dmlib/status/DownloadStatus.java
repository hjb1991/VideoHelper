package org.kgmeng.dmlib.status;

/**
 * DownloadStatus
 * 下载状态
 * @author JF Zhang
 * @date 2015/8/21
 */
public enum DownloadStatus {

    NONE(0),
    WAIT(0x21),  //等待  33
    DLING(0x22), //下载中 34
    PAUSE(0x23), //暂停  35
    DONE(0x25),  //完成
    ERROR(0x26);  //失败

    private int value;
    DownloadStatus(int val) {
        this.value = val;
    }
    public int getValue() {
        return value;
    }
}
