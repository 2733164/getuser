package com.star.getuser.entity;

import java.io.Serializable;

/**
 * (Webuser)实体类
 *
 * @author makejava
 * @since 2023-06-28 17:38:50
 */
public class User implements Serializable {
    private static final long serialVersionUID = 491616722873710350L;
    
    private Integer id;
    /**
     * 父级id,裂变用
     */
    private Integer pId;
    /**
     * 返利比例
     */
    private Integer rebate;
    
    private String username;
    
    private String password;
    
    private String nickname;
    
    private Long createtime;
    
    private Integer sex;
    
    private String avatar;
    /**
     * 1是 0不是
     */
    private String isvip;
    
    private Long phonenumber;
    /**
     * 提问次数
     */
    private Integer actionnum;
    /**
     * 最后一次登录
     */
    private Long lastlogin;
    /**
     * ip
     */
    private String ip;
    
    private Integer gptfreenum;
    
    private Integer mjfreenum;
    /**
     * mj操作次数

     */
    private Integer mjactionnum;
    /**
     * 来源地址
     */
    private String usersource;
    /**
     * 单点登录唯一值 token
     */
    private Long uuid;
    /**
     * 签到日期
     */
    private Long signdate;
    /**
     * 免费快速次数
     */
    private Integer fastnum;
    /**
     * gpt4免费次数
     */
    private Integer gpt4freenum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public Integer getRebate() {
        return rebate;
    }

    public void setRebate(Integer rebate) {
        this.rebate = rebate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIsvip() {
        return isvip;
    }

    public void setIsvip(String isvip) {
        this.isvip = isvip;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getActionnum() {
        return actionnum;
    }

    public void setActionnum(Integer actionnum) {
        this.actionnum = actionnum;
    }

    public Long getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Long lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getGptfreenum() {
        return gptfreenum;
    }

    public void setGptfreenum(Integer gptfreenum) {
        this.gptfreenum = gptfreenum;
    }

    public Integer getMjfreenum() {
        return mjfreenum;
    }

    public void setMjfreenum(Integer mjfreenum) {
        this.mjfreenum = mjfreenum;
    }

    public Integer getMjactionnum() {
        return mjactionnum;
    }

    public void setMjactionnum(Integer mjactionnum) {
        this.mjactionnum = mjactionnum;
    }

    public String getUsersource() {
        return usersource;
    }

    public void setUsersource(String usersource) {
        this.usersource = usersource;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getSigndate() {
        return signdate;
    }

    public void setSigndate(Long signdate) {
        this.signdate = signdate;
    }

    public Integer getFastnum() {
        return fastnum;
    }

    public void setFastnum(Integer fastnum) {
        this.fastnum = fastnum;
    }

    public Integer getGpt4freenum() {
        return gpt4freenum;
    }

    public void setGpt4freenum(Integer gpt4freenum) {
        this.gpt4freenum = gpt4freenum;
    }

}

